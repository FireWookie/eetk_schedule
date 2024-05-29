package ru.eetk.platform.permission.delegate

import org.koin.core.component.KoinComponent
import ru.eetk.platform.permission.model.PermissionState

internal interface PermissionDelegate: KoinComponent {
    fun getPermissionState(): PermissionState
    suspend fun providePermission()
    fun openSettingPage()
}
