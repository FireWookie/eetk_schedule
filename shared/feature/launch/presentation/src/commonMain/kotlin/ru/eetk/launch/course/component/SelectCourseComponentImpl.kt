package ru.eetk.launch.course.component

import com.arkivanov.decompose.ComponentContext
import models.BranchUI

fun buildSelectCourseComponent(
    componentContext: ComponentContext,
    branchUI: BranchUI,
    onOpenMainFlow: () -> Unit
): SelectCourseComponent = SelectCourseComponentImpl(
    componentContext = componentContext,
    branchUI = branchUI,
    onOpenMainFlow
)

internal class SelectCourseComponentImpl(
    componentContext: ComponentContext,
    private val branchUI: BranchUI,
    private val onOpenMainFlow: () -> Unit
): ComponentContext by componentContext, SelectCourseComponent {
    override fun openMainFlow() = onOpenMainFlow()
    override fun selectCourse(course: Int) {
        onOpenMainFlow.invoke()
    }
}