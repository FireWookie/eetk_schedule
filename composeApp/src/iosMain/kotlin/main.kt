import androidx.compose.ui.window.ComposeUIViewController
import component.RootComponent
import platform.UIKit.UIViewController
import ru.eetk.mobileapp.App
import screen.RootScreen

fun MainViewController(
    component: RootComponent
): UIViewController = ComposeUIViewController { RootScreen(component) }
