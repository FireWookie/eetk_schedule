package ru.eetk.review.root.component

import com.arkivanov.decompose.ComponentContext

fun buildReviewRootComponent(
    componentContext: ComponentContext
): ReviewRootComponent = ReviewRootComponentImpl(
    componentContext = componentContext
)

internal class ReviewRootComponentImpl(
    componentContext: ComponentContext
): ReviewRootComponent, ComponentContext by componentContext {

}