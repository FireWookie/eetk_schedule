package ru.eetk.launch.root.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.eetk.launch.branch.screen.SelectBranchScreen
import ru.eetk.launch.course.screen.SelectCourseScreen
import ru.eetk.launch.root.animation.backAnimation
import ru.eetk.launch.root.component.LaunchComponent

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun LaunchScreen(component: LaunchComponent) {
    val stack by component.childStack.subscribeAsState()

    Children(
        stack = stack,
        animation = backAnimation(
            backHandler = component.backHandler,
            onBack = component::onBackClicked
        )
    ) { config ->
        when(val child = config.instance) {
            is LaunchComponent.Child.Branch -> SelectBranchScreen(
                component = child.component
            )
            is LaunchComponent.Child.Course -> SelectCourseScreen(
                component = child.component
            )
        }
    }
}