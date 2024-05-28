package ru.eetk.launch.course.component

import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.flow.StateFlow
import ru.eetk.launch.course.component.store.CourseStore

interface SelectCourseComponent {

    val stateFlow: StateFlow<CourseStore.State>

    fun onBackClicked()

    fun saveData()

    fun onDDMDismissRequest()

    fun onDDMChangeItem(item: Pair<Int, StringResource>)

    fun onDDMClicked()
}