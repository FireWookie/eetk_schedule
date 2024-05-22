package ru.eetk.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val flowModule = module {
    single<StoreFactory> {
        DefaultStoreFactory()
    }
}