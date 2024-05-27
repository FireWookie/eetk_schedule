package ru.eetk.settings.menu.component

import com.arkivanov.decompose.ComponentContext
import ru.eetk.theme.util.BaseComponent

internal fun buildSettingsMenuComponent(
    componentContext: ComponentContext,
    profileClick: () -> Unit,
    notificationClick: () -> Unit,
    designClick: () -> Unit
): SettingsMenuComponent = SettingsMenuComponentImpl(
    componentContext = componentContext,
    profileClick = profileClick,
    notificationClick = notificationClick,
    designClick = designClick
)

internal class SettingsMenuComponentImpl(
    componentContext: ComponentContext,
    private val profileClick: () -> Unit,
    private val notificationClick: () -> Unit,
    private val designClick: () -> Unit
): SettingsMenuComponent, BaseComponent(componentContext) {

    override fun onProfileClick() = profileClick()

    override fun onNotificationClick() = notificationClick()

    override fun onDesignClick() = designClick()
}