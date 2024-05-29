package ru.eetk.libraries.flow.models

sealed interface SelectedTab {
    data object SettingsTab: SelectedTab
}