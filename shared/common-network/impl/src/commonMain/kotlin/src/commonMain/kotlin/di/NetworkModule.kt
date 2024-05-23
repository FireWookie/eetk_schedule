package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import providers.provideJson

val networkModule = module {
    factoryOf(::provideJson)
}