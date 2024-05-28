package ru.eetk.settings.profile.component.config

import kotlinx.serialization.Serializable


@Serializable
sealed class RootBottomSheetConfig {
    @Serializable
    data object PhotoSelectorScreen : RootBottomSheetConfig()
}