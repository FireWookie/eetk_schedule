package ru.eetk.platform.permission.util

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.eetk.platform.permission.delegate.PermissionDelegate
import ru.eetk.platform.permission.model.Permission

internal fun KoinComponent.getPermissionDelegate(permission: Permission): PermissionDelegate {
    val permissionDelegate by inject<PermissionDelegate>(named(permission.name))
    return permissionDelegate
}
