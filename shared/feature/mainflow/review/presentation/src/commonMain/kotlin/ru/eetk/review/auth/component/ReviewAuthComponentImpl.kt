package ru.eetk.review.auth.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import ru.eetk.review.root.component.ReviewRootComponent
import ru.eetk.theme.util.BaseComponent

fun buildReviewAuthComponent(
    componentContext: ComponentContext
): ReviewAuthComponent = ReviewAuthComponentImpl(
    componentContext = componentContext
)

internal class ReviewAuthComponentImpl(
    componentContext: ComponentContext
): ReviewAuthComponent, BaseComponent(componentContext = componentContext) {
    override fun onAuthClicked() {}
}