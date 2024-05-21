package ru.eetk.di

import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module

object KoinInjector {

    val koinApp = startKoin {
        loadKoinModules(
            listOf(
                platformDataStoreModule
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }
}

internal expect val platformDataStoreModule: Module