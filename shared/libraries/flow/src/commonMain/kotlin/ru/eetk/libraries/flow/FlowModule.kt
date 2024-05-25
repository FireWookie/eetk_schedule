package ru.eetk.libraries.flow

import kotlinx.coroutines.flow.MutableSharedFlow
import models.SelectedTab
import org.koin.core.qualifier.named
import org.koin.dsl.module

val flowModule = module {
    single<MutableSharedFlow<SelectedTab.SettingsTab>>(named("TabFlow")) {
        MutableSharedFlow(replay = 1)
    }
}