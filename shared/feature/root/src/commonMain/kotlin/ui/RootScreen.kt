package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import component.RootComponent
import ru.eetk.animation.stackAnim
import ru.eetk.launch.root.ui.LaunchScreen
import ru.eetk.mainflow.ui.MainFlowScreen
import ru.eetk.persistent.appearance.Theme
import ru.eetk.splash.ui.SplashScreen
import ru.eetk.theme.EETKTheme


@Composable
fun RootScreen(
    component: RootComponent,
    modifier: Modifier = Modifier,
    isDark: (Boolean) -> Unit = {}
) {
    val theme by component.theme.collectAsState()
    theme?.let {
        println("Theme value: ${it.name}")
        val isDarkTheme = when (it) {
            Theme.System -> isSystemInDarkTheme()
            Theme.Dark -> true
            Theme.Light -> false
        }
        DisposableEffect(isDarkTheme) {
            isDark.invoke(isDarkTheme)
            onDispose {  }
        }
        EETKTheme(isDark = isDarkTheme) {
            Children(
                stack = component.childStack,
                modifier = modifier,
                animation = stackAnim()
            ) {
                when (val child = it.instance) {
                    is RootComponent.Child.Launch -> LaunchScreen(child.component)
                    is RootComponent.Child.MainFlow -> MainFlowScreen(child.component)
                    is RootComponent.Child.Splash -> SplashScreen(child.component)
                }
            }
        }
    }
}