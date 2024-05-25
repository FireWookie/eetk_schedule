package ru.eetk.settings.design.component

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

internal fun buildDesignComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit
): DesignComponent = DesignComponentImpl(
    componentContext = componentContext,
    backClick = backClick
)
internal class DesignComponentImpl(
    componentContext: ComponentContext,
    private val backClick: () -> Unit,
): DesignComponent, ComponentContext by componentContext, KoinComponent {
    override fun onBackClicked() = backClick()
}