package ru.eetk.launch.root.component

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import models.BranchUI
import ru.eetk.launch.branch.component.SelectBranchComponent
import ru.eetk.launch.course.component.SelectCourseComponent

@Stable
interface LaunchComponent {
    fun openMainFlow()

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class Branch(val component: SelectBranchComponent): Child()

        class Course(val component: SelectCourseComponent): Child()
    }
}