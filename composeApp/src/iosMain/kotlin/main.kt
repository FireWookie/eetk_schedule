import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackGestureOverlay
import com.arkivanov.essenty.backhandler.BackDispatcher
import component.RootComponent
import platform.UIKit.UIViewController
import ru.eetk.theme.EETKTheme
import ui.RootScreen

@OptIn(ExperimentalDecomposeApi::class)
fun MainViewController(
    component: RootComponent,
    backDispatcher: BackDispatcher
): UIViewController = ComposeUIViewController {
    PredictiveBackGestureOverlay(
        backDispatcher = backDispatcher,
        backIcon = { progress, _ -> },
        modifier = Modifier.fillMaxSize()
    ) {
        RootScreen(component)
    }
}
