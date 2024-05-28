package ru.eetk.settings.design.component.store

import com.arkivanov.mvikotlin.core.store.Store
import dev.icerock.moko.resources.StringResource
import ru.eetk.persistent.appearance.Theme
import ru.eetk.resources.EetkRes

interface DesignStore : Store<DesignStore.Intent, DesignStore.State, Nothing> {

    sealed interface Intent {
        data class ChangeSelectedTheme(val theme: Pair<Theme, StringResource>): Intent

        data object ChangeExpanded: Intent

        data object ChangeDynamicColors: Intent

    }

    sealed interface Message {
        data class SelectTheme(val theme: Pair<Theme, StringResource>): Message

        data object ChangeExpanded: Message

        data object ChangeDynamicColors: Message

        data class SelectThemeByFilter(val theme: Theme): Message
    }

    data class State(
        val dynamicColors: Boolean = false,
        val selectedTheme: Pair<Theme, StringResource> = THEME_LIST.first(),
        val items: List<Pair<Theme, StringResource>> = THEME_LIST,
        val expanded: Boolean = false

    ) {
        companion object {
            val THEME_LIST = listOf(
                Pair(Theme.System, EetkRes.strings.system_theme),
                Pair(Theme.Light, EetkRes.strings.dark_off_theme),
                Pair(Theme.Dark, EetkRes.strings.dark_on_theme)
            )
        }
    }
}