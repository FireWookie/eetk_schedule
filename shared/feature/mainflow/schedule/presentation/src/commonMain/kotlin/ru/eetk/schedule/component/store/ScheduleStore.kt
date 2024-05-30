package ru.eetk.schedule.component.store

import com.arkivanov.mvikotlin.core.store.Store
import dev.icerock.moko.resources.StringResource
import ru.eetk.resources.EetkRes

interface ScheduleStore: Store<ScheduleStore.Intent, ScheduleStore.State, Nothing> {

    sealed interface Intent {
        data class ChangeSegment(val segment: Pair<Int, StringResource>): Intent
    }
    sealed interface Message {
        data class SelectSegment(val segment: Pair<Int, StringResource>): Message
    }
    data class State(
        val selectedSegment: Pair<Int, StringResource> = SEGMENT_LIST.first(),
        val segments: List<Pair<Int, StringResource>> = SEGMENT_LIST,
    ) {
        companion object {
            private val SEGMENT_LIST = listOf(
                Pair(0, EetkRes.strings.schedule),
                Pair(1, EetkRes.strings.changes)
            )
        }
    }
}