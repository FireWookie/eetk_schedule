package ru.eetk.platform.permission

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.eetk.platform.permission.delegate.CameraPermissionDelegate
import ru.eetk.platform.permission.delegate.PermissionDelegate
import ru.eetk.platform.permission.delegate.ReadFilesPermissionDelegate
import ru.eetk.platform.permission.model.Permission

actual val platformPermissionModule = module {
    single<PermissionDelegate>(named(Permission.CAMERA.name)) {
        CameraPermissionDelegate()
    }

    single<PermissionDelegate>(named(Permission.READ_EXTERNAL_STORAGE.name)) {
        ReadFilesPermissionDelegate()
    }
}