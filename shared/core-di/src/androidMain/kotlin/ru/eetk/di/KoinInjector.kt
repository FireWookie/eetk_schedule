package ru.eetk.di

import android.content.Context
import org.koin.dsl.module
import ru.eetk.datastore.dataStore


internal actual val platformDataStoreModule = module {
    single { get<Context>().dataStore() }
}