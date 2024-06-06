package ru.eetk.launch.root.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import io.github.alexzhirkevich.cupertino.decompose.NativeChildren
import ru.eetk.animation.backAnimation
import ru.eetk.animation.stackAnim
import ru.eetk.launch.branch.ui.SelectBranchScreen
import ru.eetk.launch.course.ui.SelectCourseScreen
import ru.eetk.launch.root.component.LaunchComponent

@Composable
fun LaunchScreen(component: LaunchComponent) {
    NativeChildren(
        stack = component.childStack,
        onBack = component::onBackClicked,
        modifier = Modifier.fillMaxSize(),
        animation = stackAnim()
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