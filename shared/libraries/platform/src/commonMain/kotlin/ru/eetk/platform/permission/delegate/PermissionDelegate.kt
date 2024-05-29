package ru.eetk.platform.permission.delegate

import ru.eetk.platform.permission.model.PermissionState

internal interface PermissionDelegate {
    fun getPermissionState(): PermissionState
    suspend fun providePermission()
    fun openSettingPage()
}
