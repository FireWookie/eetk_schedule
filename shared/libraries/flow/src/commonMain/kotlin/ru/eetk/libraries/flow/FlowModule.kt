package ru.eetk.libraries.flow

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.eetk.libraries.flow.models.SelectedTab
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.eetk.libraries.flow.FlowConstants.ROOT_FLOW
import ru.eetk.libraries.flow.FlowConstants.ROOT_FLOW_EVENT
import ru.eetk.libraries.flow.FlowConstants.TAB_FLOW
import ru.eetk.libraries.flow.models.CaptureData
import ru.eetk.libraries.flow.models.EffectRoot

val flowModule = module {
    single<MutableSharedFlow<SelectedTab.SettingsTab>>(named(TAB_FLOW)) {
        MutableSharedFlow(replay = 1)
    }

    single<MutableSharedFlow<EffectRoot>>(named(ROOT_FLOW)) {
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    }

    single<MutableSharedFlow<CaptureData>>(named(ROOT_FLOW_EVENT)) {
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    }
}