package ru.eetk.platform.permission.delegate

import platform.Photos.PHAuthorizationStatus
import platform.Photos.PHAuthorizationStatusAuthorized
import platform.Photos.PHAuthorizationStatusDenied
import platform.Photos.PHAuthorizationStatusNotDetermined
import platform.Photos.PHPhotoLibrary
import ru.eetk.platform.permission.model.PermissionState
import ru.eetk.platform.permission.openAppSettingsPage
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

actual class ReadFilesPermissionDelegate : PermissionDelegate {
    override fun getPermissionState(): PermissionState {
        return when (val status: PHAuthorizationStatus = PHPhotoLibrary.authorizationStatus()) {
            PHAuthorizationStatusAuthorized -> PermissionState.GRANTED
            PHAuthorizationStatusNotDetermined -> PermissionState.NOT_DETERMINED
            PHAuthorizationStatusDenied -> PermissionState.DENIED
            else -> error("unknown gallery authorization status $status")
        }
    }

    override suspend fun providePermission() {
        when (PHPhotoLibrary.authorizationStatus()) {
            PHAuthorizationStatusAuthorized -> return
            PHAuthorizationStatusNotDetermined -> {
                suspendCoroutine { continuation ->
                    requestGalleryAccess { continuation.resume(it) }
                }
                providePermission()
            }
        }
    }

    override fun openSettingPage() {
        openAppSettingsPage()
    }


    private fun requestGalleryAccess(callback: (PHAuthorizationStatus) -> Unit) {
        PHPhotoLibrary.requestAuthorization { status: PHAuthorizationStatus ->
            callback(status)
        }
    }
}