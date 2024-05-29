package ru.eetk.platform.permission

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationOpenSettingsURLString
import ru.eetk.platform.permission.service.PermissionsService
import ru.eetk.platform.permission.util.CannotOpenSettingsException


fun openNSUrl(string: String) {
    val settingsUrl: NSURL = NSURL.URLWithString(string)!!
    if (UIApplication.sharedApplication.canOpenURL(settingsUrl)) {
        UIApplication.sharedApplication.openURL(settingsUrl)
    } else throw CannotOpenSettingsException(string)
}

/**
 * Функция для перехода в настройки приложения
 */
internal fun openAppSettingsPage() {
    openNSUrl(UIApplicationOpenSettingsURLString)
}

internal fun CoroutineScope.observePermission(
    frequency: Long = PermissionsService.PERMISSION_CHECK_FLOW_FREQUENCY,
    block: suspend () -> Unit,
): Job = launch {
    while (true) {
        block()
        delay(frequency)
    }
}
