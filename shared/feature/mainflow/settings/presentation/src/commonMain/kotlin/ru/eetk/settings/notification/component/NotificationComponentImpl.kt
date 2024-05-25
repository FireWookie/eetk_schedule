package ru.eetk.settings.notification.component

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

internal fun buildNotificationComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit,
): NotificationComponent = NotificationComponentImpl(
    componentContext =  componentContext,
    backClick = backClick
)

internal class NotificationComponentImpl(
    componentContext: ComponentContext,
    private val backClick: () -> Unit
): NotificationComponent, ComponentContext by componentContext, KoinComponent {
    override fun onBackClicked() = backClick()
}