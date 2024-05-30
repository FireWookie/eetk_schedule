package ru.eetk.schedule.component

import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.flow.StateFlow
import ru.eetk.schedule.component.store.ScheduleStore.State

interface ScheduleComponent {

    val stateFlow: StateFlow<State>

    fun onChangeSegment(segment: Pair<Int, StringResource>)
}