package ru.eetk.schedule.root.component

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.serialization.Serializable
import ru.eetk.schedule.changes.component.ChangesComponent
import ru.eetk.schedule.schedule.component.ScheduleComponent

@OptIn(ExperimentalDecomposeApi::class)
interface ScheduleRootComponent {
    fun changeSegment(index: Int)

    val pages: Value<ChildPages<*, Segments>>
    val configs: List<Config>

    sealed interface Segments {
        data class Schedule(val component: ScheduleComponent): Segments
        data class Changes(val component: ChangesComponent): Segments
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object Schedule : Config

        @Serializable
        data object Changes : Config
    }
}