package ru.eetk.mainflow.component

import kotlinx.serialization.Serializable

@Serializable
sealed interface MainTabNavigation {
    @Serializable
    data object Schedule : MainTabNavigation

    @Serializable
    data object Review: MainTabNavigation

    @Serializable
    data object Settings : MainTabNavigation
}