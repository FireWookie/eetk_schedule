package screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.FaultyDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import component.RootComponent
import ru.eetk.launch.root.screen.LaunchScreen
import ru.eetk.mainflow.screen.MainFlowScreen
import ru.eetk.theme.EETKTheme

@OptIn(FaultyDecomposeApi::class)
@Composable
fun RootScreen(
    component: RootComponent,
    modifier: Modifier = Modifier
) = EETKTheme() {

    Column(
        modifier = Modifier.systemBarsPadding()
    ) {
        Children(
            stack = component.childStack,
            modifier = modifier,
            animation = stackAnimation { _, _, direction ->
                when (direction) {
                    Direction.ENTER_FRONT -> FrontAnim
                    Direction.EXIT_FRONT -> BackAnim
                    Direction.ENTER_BACK -> FrontAnim
                    Direction.EXIT_BACK -> BackAnim
                }
            }
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.Launch -> LaunchScreen(child.component)
                is RootComponent.Child.MainFlow -> MainFlowScreen(child.component)
            }
        }
    }
}

private const val ANIMATION_THRESHOLD = 0.55f
private const val ANIMATION_DURATION = 300

private val Int.Disappearing: Int
    get() = (this * ANIMATION_THRESHOLD).toInt()

private val Int.Appearing: Int
    get() = this - this.Disappearing

private val BackAnim = fade(
    animationSpec = tween(
        durationMillis = 50,
        delayMillis = 0,
        easing = FastOutSlowInEasing
    )
) + slide(
    animationSpec = tween(
        durationMillis = ANIMATION_DURATION,
        easing = FastOutSlowInEasing
    )
)
private val FrontAnim = fade(
    animationSpec = tween(
        durationMillis = ANIMATION_DURATION.Appearing,
        delayMillis = ANIMATION_DURATION.Disappearing,
        easing = LinearOutSlowInEasing
    )
) + slide(
    animationSpec = tween(
        durationMillis = ANIMATION_DURATION,
        easing = FastOutSlowInEasing
    )
)

// Для Predictive Back android

//private fun animation(component: RootComponent) = predictiveBackAnimation(
//    backHandler = component.backHandler,
//    selector = { initialBackEvent, _, _ ->
//        androidPredictiveBackAnimatable(initialBackEvent = initialBackEvent)
//    },
//    onBack = component::onBackClicked,
//    fallbackAnimation = stackAnimation { _, _, direction ->
//        when (direction) {
//            Direction.ENTER_FRONT -> FrontAnim
//            Direction.EXIT_FRONT -> BackAnim
//            Direction.ENTER_BACK -> FrontAnim
//            Direction.EXIT_BACK -> BackAnim
//        }
//    }
//)