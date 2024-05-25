package screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import component.RootComponent
import ru.eetk.launch.root.screen.LaunchScreen
import ru.eetk.mainflow.screen.MainFlowScreen
import ru.eetk.theme.EETKTheme

@Composable
fun RootScreen(
    component: RootComponent,
    modifier: Modifier = Modifier
) = EETKTheme {
        Children(
            stack = component.childStack,
            modifier = modifier,
            animation = stackAnimation(fade())

        ) {
            when (val child = it.instance) {
                is RootComponent.Child.Launch -> LaunchScreen(child.component)
                is RootComponent.Child.MainFlow -> MainFlowScreen(child.component)
            }
        }
    }

