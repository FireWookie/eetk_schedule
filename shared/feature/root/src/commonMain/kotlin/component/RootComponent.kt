package component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow
import ru.eetk.launch.root.component.LaunchComponent
import ru.eetk.mainflow.component.MainFlowComponent
import ru.eetk.persistent.appearance.Theme
import ru.eetk.photo_selector.capture_photo.component.CapturePhotoComponent
import ru.eetk.splash.component.SplashComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    val theme: StateFlow<Theme?>

    sealed class Child {
        class Launch(val component: LaunchComponent): Child()
        class MainFlow(val component: MainFlowComponent): Child()

        class Splash(val component: SplashComponent): Child()

        class Camera(val component: CapturePhotoComponent): Child()
    }
}