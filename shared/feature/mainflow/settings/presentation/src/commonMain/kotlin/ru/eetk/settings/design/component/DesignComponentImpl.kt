package ru.eetk.settings.design.component

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
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

    override fun onDynamicColorChange() {
        TODO("Not yet implemented")
    }

    override fun onSystemThemeClicked() {
        TODO("Not yet implemented")
    }

    override fun onOffDarkThemeClicked() {
        TODO("Not yet implemented")
    }

    override fun onOnDarkThemeClicked() {
        TODO("Not yet implemented")
    }
}