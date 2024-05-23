package ru.eetk.settings.notification.component

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

internal fun buildNotificationComponent(
    componentContext: ComponentContext
): NotificationComponent = NotificationComponentImpl(
    componentContext =  componentContext
)

internal class NotificationComponentImpl(
    componentContext: ComponentContext
): NotificationComponent, ComponentContext by componentContext, KoinComponent {
}