import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackGestureIcon
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackGestureOverlay
import com.arkivanov.essenty.backhandler.BackDispatcher
import component.RootComponent
import platform.UIKit.UIViewController
import ru.eetk.mobileapp.App
import screen.RootScreen

@OptIn(ExperimentalDecomposeApi::class)
fun MainViewController(
    component: RootComponent,
    backDispatcher: BackDispatcher
): UIViewController = ComposeUIViewController {
    PredictiveBackGestureOverlay(
        backDispatcher = backDispatcher,
        backIcon = { progress, _ ->
            PredictiveBackGestureIcon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                progress = progress
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        RootScreen(component)
    }
}
