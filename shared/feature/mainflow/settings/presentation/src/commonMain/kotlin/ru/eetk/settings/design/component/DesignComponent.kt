package ru.eetk.settings.design.component

import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.flow.StateFlow
import ru.eetk.persistent.appearance.Theme
import ru.eetk.settings.design.component.store.DesignStore

interface DesignComponent {

    val stateFlow: StateFlow<DesignStore.State>

    fun onBackClicked()

    fun onThemeClicked()

    fun onChangeDynTheme(state: Boolean)

    fun onChangeThemeItem(theme: StringResource)

}