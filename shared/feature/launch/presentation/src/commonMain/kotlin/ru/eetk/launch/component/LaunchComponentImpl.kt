package ru.eetk.launch.component

import com.arkivanov.decompose.ComponentContext

fun buildLaunchComponent(
    componentContext: ComponentContext,
    onOpenMainFlow: () -> Unit,
): LaunchComponent = LaunchComponentImpl(
    componentContext = componentContext,
    onOpenMainFlow = onOpenMainFlow
)

internal class LaunchComponentImpl(
    componentContext: ComponentContext,
    private val onOpenMainFlow: () -> Unit
) : LaunchComponent, ComponentContext by componentContext {

    override fun openMainFlow() = onOpenMainFlow()
}