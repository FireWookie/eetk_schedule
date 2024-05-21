package ru.eetk.di

import org.koin.dsl.module
import ru.eetk.datastore.dataStore


internal actual val platformDataStoreModule = module {
    single { dataStore() }
}