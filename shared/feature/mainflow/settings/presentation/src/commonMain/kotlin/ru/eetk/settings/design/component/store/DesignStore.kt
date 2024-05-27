package ru.eetk.settings.design.component.store

import com.arkivanov.mvikotlin.core.store.Store
import dev.icerock.moko.resources.StringResource
import ru.eetk.persistent.appearance.Theme
import ru.eetk.resources.EetkRes

interface DesignStore : Store<DesignStore.Intent, DesignStore.State, Nothing> {

    sealed interface Intent {
        data class ChangeSelectedTheme(val theme: StringResource): Intent

        data object ChangeExpanded: Intent

        data object ChangeDynamicColors: Intent

    }

    sealed interface Message {
        data class SelectTheme(val theme: StringResource): Message

        data object ChangeExpanded: Message

        data object ChangeDynamicColors: Message
    }

    data class State(
        val dynamicColors: Boolean = false,
        val selectedTheme: Int = 0,
        val themeItems: StringResource = THEME_LIST[selectedTheme],
        val items: List<StringResource> = THEME_LIST,
        val expanded: Boolean = false

    ) {
        companion object {
            val THEME_LIST = listOf(
                EetkRes.strings.system_theme,
                EetkRes.strings.dark_off_theme,
                EetkRes.strings.dark_on_theme
            )
        }
    }
}