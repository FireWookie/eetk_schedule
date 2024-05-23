package ru.eetk.settings.design.component

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

internal fun buildDesignComponent(
    componentContext: ComponentContext
): DesignComponent = DesignComponentImpl(
    componentContext = componentContext
)
internal class DesignComponentImpl(
    componentContext: ComponentContext
): DesignComponent, ComponentContext by componentContext, KoinComponent {

}