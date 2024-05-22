package ru.eetk.launch.root.component

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandler
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import models.BranchUI
import ru.eetk.launch.branch.component.SelectBranchComponent
import ru.eetk.launch.course.component.SelectCourseComponent

@Stable
interface LaunchComponent: BackHandlerOwner {
    fun openMainFlow()

    val childStack: Value<ChildStack<*, Child>>

    fun onBackClicked()

    sealed class Child {
        class Branch(val component: SelectBranchComponent): Child()

        class Course(val component: SelectCourseComponent): Child()
    }
}