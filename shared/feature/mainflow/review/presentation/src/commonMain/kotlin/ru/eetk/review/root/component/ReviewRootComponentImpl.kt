package ru.eetk.review.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.eetk.review.auth.component.buildReviewAuthComponent
import ru.eetk.theme.util.BaseComponent

fun buildReviewRootComponent(
    componentContext: ComponentContext,
): ReviewRootComponent = ReviewRootComponentImpl(
    componentContext = componentContext
)

internal class ReviewRootComponentImpl(
    componentContext: ComponentContext,
) : ReviewRootComponent, BaseComponent(componentContext = componentContext) {

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, ReviewRootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Auth,
            handleBackButton = true,
            childFactory = ::processChild,
            serializer = Config.serializer()
        )

    private fun processChild(
        config: Config,
        componentContext: ComponentContext,
    ) = when (config) {
        Config.Auth -> ReviewRootComponent.Child.Auth(
            buildReviewAuthComponent(
                componentContext = componentContext
            )
        )
    }

    override fun onBackClicked() {
        navigation.pop()
    }


    @Serializable
    sealed interface Config {
        @Serializable
        data object Auth : Config
    }
}