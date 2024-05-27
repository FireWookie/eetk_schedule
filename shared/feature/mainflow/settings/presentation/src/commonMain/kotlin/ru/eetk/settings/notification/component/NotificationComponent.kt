package ru.eetk.settings.notification.component

import androidx.compose.runtime.State

interface NotificationComponent {

    val switchSchedule: State<Boolean>

    val switchChanges: State<Boolean>

    fun onBackClicked()

    fun onSwitchScheduleState(state: Boolean)

    fun onSwitchChangesState(state: Boolean)
}