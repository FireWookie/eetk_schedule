package ru.eetk.platform.permission

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.core.app.ActivityCompat
import ru.eetk.platform.permission.model.Permission
import ru.eetk.platform.permission.model.PermissionState
import ru.eetk.platform.permission.util.CannotOpenSettingsException

/**
 * @author [FireWookie]
 */

/**
 *  Функция для открытия новой страницы приложения с определенным действием и данными.
 *   @param action Действие при открытии страницы.
 *   @param newData по умолчанию null, при необходимости указываем нужоную ссылку
 *   @param onError  в случае возникновения исключения при открытии страницы возвращаем Exception
 *
 *   Intent.FLAG_ACTIVITY_NEW_TASK - производит действие в новом окне
 */

internal fun Context.openPage(
    action: String,
    newData: Uri? = null,
    onError: (Exception) -> Unit,
) {
    try {
        val intent = Intent(action).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            newData?.let { data = it }
        }
        startActivity(intent)
    } catch (e: Exception) {
        onError(e)
    }
}

/**
 * Проверка на состояние разрешения
 * @param context
 * @param activity
 * @param permissions - набор разрешений
 * @return PermissionState(DENIED,GRANTED, NOT_DETERMINED)
 * checkSelfPermission - проверяет наличие переданного разрешения
 * перебираем переданные разрешения и проверяем есть ли возможность их выдать
 * shouldShowRequestPermissionRationale- отслеживает возможно ли вызвать диалог с разрешением, если нет
 * логируем ошибку
 */
internal fun checkPermissions(
    context: Context,
    activity: Activity,
    permissions: List<String>,
): PermissionState {
    permissions.ifEmpty { return PermissionState.GRANTED } // no permissions needed
    val status: List<Int> = permissions.map {
        context.checkSelfPermission(it)
    }
    val isAllGranted: Boolean = status.all { it == PackageManager.PERMISSION_GRANTED }
    if (isAllGranted) return PermissionState.GRANTED

    val isAllRequestRationale: Boolean = try {
        permissions.all {
            !activity.shouldShowRequestPermissionRationale(it)
        }
    } catch (t: Throwable) {
        t.printStackTrace()
        true
    }
    return if (isAllRequestRationale) PermissionState.NOT_DETERMINED
    else PermissionState.DENIED
}

/**
 * Функция для запроса разрешений у пользователя.
 * @param permissions Список разрешений, которые необходимо запросить.
 * @param onError Функция обработки ошибки, которая будет вызвана в случае возникновения исключения при запросе разрешений.
 */

internal fun Activity.providePermissions(
    permissions: List<String>,
    onError: (Throwable) -> Unit,
) {
    try {
        ActivityCompat.requestPermissions(
            this, permissions.toTypedArray(), 100
        )
    } catch (t: Throwable) {
        onError(t)
    }
}

/**
 * Функция для открытия страницы настроек приложения, где пользователь может управлять разрешениями.
 * @param permission Разрешение, для которого необходимо открыть страницу настроек.
 * @throws CannotOpenSettingsException Если не удается открыть страницу настроек.
 * Settings.ACTION_APPLICATION_DETAILS_SETTINGS - открывает экран настроек приложения, которое запущено
 */
internal fun Context.openAppSettingsPage(permission: Permission) {
    openPage(
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        newData = Uri.parse("package:$packageName"),
        onError = { throw CannotOpenSettingsException(permission.name) }
    )
}