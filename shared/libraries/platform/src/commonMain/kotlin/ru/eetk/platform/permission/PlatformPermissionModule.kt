package ru.eetk.platform.permission

import ru.eetk.platform.permission.delegate.CameraPermissionDelegate
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.eetk.platform.permission.delegate.PermissionDelegate
import ru.eetk.platform.permission.delegate.ReadFilesPermissionDelegate
import ru.eetk.platform.permission.model.Permission
import ru.eetk.platform.permission.service.PermissionsService
import ru.eetk.platform.permission.service.PermissionsServiceImpl


val corePermissionModule: Module = module {
    single<PermissionsService> {
        PermissionsServiceImpl()
    }
}

expect val platformPermissionModule: Module
