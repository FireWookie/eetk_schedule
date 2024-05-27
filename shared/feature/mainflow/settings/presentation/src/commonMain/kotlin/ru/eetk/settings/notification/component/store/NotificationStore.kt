package ru.eetk.settings.notification.component.store

import com.arkivanov.mvikotlin.core.store.Store

interface NotificationStore : Store<NotificationStore.Intent, NotificationStore.State, Nothing> {

    sealed interface Intent {
        data object ChangeNotificationSchedule: Intent
        data object ChangeNotificationChanges: Intent
    }

    sealed interface Message {
        data object ChangeNotificationSchedule: Message
        data object ChangeNotificationChanges: Message
    }

    data class State(
        val notificationBySchedule: Boolean = false,
        val notificationByChanges: Boolean = false
    )
}