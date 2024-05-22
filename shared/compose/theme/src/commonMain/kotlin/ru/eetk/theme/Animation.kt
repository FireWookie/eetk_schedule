package ru.eetk.theme

//private const val ANIMATION_THRESHOLD = 0.55f
//private const val ANIMATION_DURATION = 300
//
//private val Int.Disappearing: Int
//    get() = (this * ANIMATION_THRESHOLD).toInt()
//
//private val Int.Appearing: Int
//    get() = this - this.Disappearing
//
//private val BackAnim =  fade(
//    animationSpec = tween(
//        durationMillis = 50,
//        delayMillis = 0,
//        easing = LinearEasing
//    )
//) + slide(
//    animationSpec = tween(
//        durationMillis = ANIMATION_DURATION,
//        easing = FastOutSlowInEasing
//    )
//)
//private val FrontAnim = fade(
//    animationSpec = tween(
//        durationMillis = ANIMATION_DURATION.Appearing,
//        delayMillis = ANIMATION_DURATION.Disappearing,
//        easing = LinearEasing
//    )
//) + slide(
//    animationSpec = tween(
//        durationMillis = ANIMATION_DURATION,
//        easing = FastOutSlowInEasing
//    )
//)