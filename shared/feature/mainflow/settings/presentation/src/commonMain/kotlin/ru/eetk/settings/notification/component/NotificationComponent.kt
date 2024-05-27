package ru.eetk.settings.notification.component

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import ru.eetk.settings.notification.component.store.NotificationStore

@Stable
interface NotificationComponent {

    val notificationStore: NotificationStore

    val state: StateFlow<NotificationStore.State>

    fun onBackClicked()

    fun onSwitchScheduleState(state: Boolean)

    fun onSwitchChangesState(state: Boolean)
}