package ru.eetk.launch.root.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
    Scaffold { insetPadding ->
        val stack by component.childStack.subscribeAsState()
        Children(
            stack = stack,
            modifier = Modifier.padding(insetPadding),
            animation = backAnimation(
              backHandler = component.backHandler,
              onBack = component::onBackClicked
            )
        ) { config ->
            when (val child = config.instance) {
                is LaunchComponent.Child.Branch -> SelectBranchScreen(
                    child.component
                )

                is LaunchComponent.Child.Course -> SelectCourseScreen(
                    child.component
                )
            }
        }
    }
}