package ru.eetk.platform.permission.delegate

import android.Manifest
import android.app.Activity
import android.content.Context
import android.os.Build
import org.koin.core.component.inject
import ru.eetk.platform.permission.checkPermissions
import ru.eetk.platform.permission.model.Permission
import ru.eetk.platform.permission.openAppSettingsPage
import ru.eetk.platform.permission.providePermissions
import ru.eetk.platform.permission.model.PermissionState
import ru.eetk.platform.permission.util.PermissionRequestException

/**
 * @author [FireWookie]
 */

/**
 *  Класс для вызова разрешения на чтение из внешнего хранилища или доступ к меди в случае выше 33 sdk
 */

actual class ReadFilesPermissionDelegate : PermissionDelegate {

    private val context by inject<Context>()

    private fun activity(): Activity {
        val temp: Activity by inject()
        return temp
    }

    override fun getPermissionState(): PermissionState {
        return checkPermissions(context, activity(), permission)
    }

    override suspend fun providePermission() {
        activity().providePermissions(permission) {
            throw PermissionRequestException(Permission.READ_EXTERNAL_STORAGE.name)
        }
    }

    override fun openSettingPage() {
        context.openAppSettingsPage(Permission.READ_EXTERNAL_STORAGE)
    }
}

private val permission: List<String> =
    listOf(
        if (Build.VERSION.SDK_INT < 33) {
            Manifest.permission.READ_EXTERNAL_STORAGE
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        } else Manifest.permission.READ_MEDIA_IMAGES,
    )