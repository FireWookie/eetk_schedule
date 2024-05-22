package ru.eetk.launch.course.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import models.BranchUI
import org.koin.core.component.KoinComponent
import ru.eetk.launch.course.store.CourseStore
import org.koin.core.component.get
import ru.eetk.launch.course.store.CourseStoreFactory

fun buildSelectCourseComponent(
    componentContext: ComponentContext,
    branchUI: BranchUI,
    onOpenMainFlow: () -> Unit
): SelectCourseComponent = SelectCourseComponentImpl(
    componentContext = componentContext,
    branchUI = branchUI,
    onOpenMainFlow = onOpenMainFlow
)

internal class SelectCourseComponentImpl(
    componentContext: ComponentContext,
    private val branchUI: BranchUI,
    private val onOpenMainFlow: () -> Unit
): ComponentContext by componentContext, SelectCourseComponent, KoinComponent {
    override fun openMainFlow() = onOpenMainFlow()

    private val courseStore: CourseStore = instanceKeeper.getStore(::get)
    override fun selectCourse(course: Int) {
        onOpenMainFlow.invoke()
    }
}