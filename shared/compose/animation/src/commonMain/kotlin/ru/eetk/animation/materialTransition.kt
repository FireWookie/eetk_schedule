package ru.eetk.animation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import com.arkivanov.decompose.FaultyDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

private const val ANIMATION_THRESHOLD = 0.55f
private const val ANIMATION_DURATION = 300

private val Int.Disappearing: Int
    get() = (this * ANIMATION_THRESHOLD).toInt()

private val Int.Appearing: Int
    get() = this - this.Disappearing

@OptIn(FaultyDecomposeApi::class)
fun <C : Any, T : Any> stackAnim(): StackAnimation<C, T> =
    stackAnimation { _, _, direction ->
        when (direction) {
            Direction.ENTER_FRONT -> FrontAnim
            Direction.EXIT_FRONT -> BackAnim
            Direction.ENTER_BACK -> FrontAnim
            Direction.EXIT_BACK -> BackAnim
        }
    }

private val BackAnim = fade(
    animationSpec = tween(
        durationMillis = 50,
        delayMillis = 0,
        easing = LinearEasing
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
        easing = LinearEasing
    )
) + slide(
    animationSpec = tween(
        durationMillis = ANIMATION_DURATION,
        easing = FastOutSlowInEasing
    )
)