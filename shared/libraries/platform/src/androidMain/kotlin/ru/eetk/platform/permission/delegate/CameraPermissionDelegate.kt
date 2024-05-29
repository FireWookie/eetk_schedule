package ru.eetk.platform.permission.delegate

import android.Manifest
import android.app.Activity
import android.content.Context
import org.koin.core.component.inject

import ru.eetk.platform.permission.checkPermissions
import ru.eetk.platform.permission.openAppSettingsPage
import ru.eetk.platform.permission.providePermissions
import ru.eetk.platform.permission.model.Permission
import ru.eetk.platform.permission.model.PermissionState
import ru.eetk.platform.permission.util.PermissionRequestException

actual class CameraPermissionDelegate : PermissionDelegate {
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
            throw PermissionRequestException(Permission.CAMERA.name)
        }
    }

    override fun openSettingPage() {
        context.openAppSettingsPage(Permission.CAMERA)
    }
}

private val permission: List<String> = listOf(Manifest.permission.CAMERA)