package ru.eetk.launch.root.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.eetk.launch.branch.screen.SelectBranchScreen
import ru.eetk.launch.course.screen.SelectCourseScreen
import ru.eetk.launch.root.component.LaunchComponent

@Composable
fun LaunchScreen(component: LaunchComponent) {
    val stack by component.childStack.subscribeAsState()
    Children(
        stack = stack
    ) { config ->
        when(val child = config.instance) {
            is LaunchComponent.Child.Branch -> SelectBranchScreen(
                child.component
            )
            is LaunchComponent.Child.Course -> SelectCourseScreen(
                child.component
            )
        }
    }
}