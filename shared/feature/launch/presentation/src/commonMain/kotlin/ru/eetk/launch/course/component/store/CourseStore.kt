package ru.eetk.launch.course.component.store

import com.arkivanov.mvikotlin.core.store.Store
import dev.icerock.moko.resources.StringResource
import ru.eetk.resources.EetkRes

interface CourseStore: Store<CourseStore.Intent, CourseStore.State, Nothing> {
    sealed interface Intent {
        data class ChangeSelectedCourse(val item: Pair<Int, StringResource>): Intent

        data object ChangeExpanded: Intent

        data class SaveInfoLaunch(val college: Int, val course: Int): Intent
    }

    sealed interface Message {
        data class SelectCourse(val item: Pair<Int, StringResource>): Message

        data object ChangeExpanded: Message
    }

    data class State(
        val selectedCourse: Int = 1,
        val courseItems: Pair<Int, StringResource> = DEFAULT_LIST.first(),
        val items: List<Pair<Int, StringResource>> = DEFAULT_LIST,
        val expanded: Boolean = false
    ) {
        companion object {
            val DEFAULT_LIST = listOf(
                Pair(1, EetkRes.strings.course),
                Pair(2, EetkRes.strings.course),
                Pair(3, EetkRes.strings.course),
                Pair(4, EetkRes.strings.course)
            )
        }
    }
}