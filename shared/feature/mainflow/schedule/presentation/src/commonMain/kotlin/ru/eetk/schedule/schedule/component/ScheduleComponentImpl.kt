package ru.eetk.schedule.schedule.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.get
import ru.eetk.theme.util.BaseComponent


fun buildScheduleComponent(
    componentContext: ComponentContext,
): ScheduleComponent = ScheduleComponentImpl(
    componentContext = componentContext,
)

internal class ScheduleComponentImpl(
    componentContext: ComponentContext
): ScheduleComponent, BaseComponent(componentContext) {

//    private val scheduleStore: ScheduleStore = instanceKeeper.getStore(::get)
//    @OptIn(ExperimentalCoroutinesApi::class)
//
//    override val stateFlow: StateFlow<State> = scheduleStore.stateFlow

}