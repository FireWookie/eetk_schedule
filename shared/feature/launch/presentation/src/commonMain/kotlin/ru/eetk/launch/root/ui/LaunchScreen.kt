package ru.eetk.launch.root.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.eetk.animation.backAnimation
import ru.eetk.launch.branch.ui.SelectBranchScreen
import ru.eetk.launch.course.ui.SelectCourseScreen
import ru.eetk.launch.root.component.LaunchComponent

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
        Scaffold { insetPadding ->
            Column(
                modifier = Modifier.padding(insetPadding)
            ) {
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
}