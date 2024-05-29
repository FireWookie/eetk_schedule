package ru.eetk.di

import ru.eetk.libraries.flow.flowModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import ru.eetk.launch.launchPresentationModule
import ru.eetk.platform.permission.corePermissionModule
import ru.eetk.platform.permission.platformPermissionModule
import ru.eetk.settings.settingsPresentationModule

object KoinInjector {

    val koinApp = startKoin {
        loadKoinModules(
            listOf(
                platformDataStoreModule,
                launchPresentationModule,
                storeModule,
                flowModule,
                settingsPresentationModule,
                corePermissionModule,
                platformPermissionModule
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }
}

internal expect val platformDataStoreModule: Module