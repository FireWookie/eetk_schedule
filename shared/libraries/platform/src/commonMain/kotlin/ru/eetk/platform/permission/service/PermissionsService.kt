package ru.eetk.platform.permission.service

import kotlinx.coroutines.flow.Flow
import ru.eetk.platform.permission.model.Permission
import ru.eetk.platform.permission.model.PermissionState

interface PermissionsService {
    fun checkPermission(permission: Permission): PermissionState
    fun checkPermissionFlow(permission: Permission): Flow<PermissionState>
    suspend fun providePermission(permission: Permission)
    fun openSettingPage(permission: Permission)

    companion object {
        const val PERMISSION_CHECK_FLOW_FREQUENCY = 1000L
    }
}
