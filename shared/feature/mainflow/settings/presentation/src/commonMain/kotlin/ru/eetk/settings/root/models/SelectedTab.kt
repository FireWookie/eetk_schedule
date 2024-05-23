package ru.eetk.settings.root.models

sealed interface SelectedTab {
    data object SettingsTab: SelectedTab
}