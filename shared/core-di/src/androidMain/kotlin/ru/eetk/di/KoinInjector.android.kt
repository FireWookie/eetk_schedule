package ru.eetk.di

import android.content.Context
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.eetk.datastore.dataStore

internal actual val platformDataStoreModule: Module = module {
    single { get<Context>().dataStore() }
}