package models

sealed interface SelectedTab {
    data object SettingsTab: SelectedTab
}