package ru.eetk.settings.notification.component

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

internal fun buildNotificationComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit
): NotificationComponent = NotificationComponentImpl(
    componentContext =  componentContext,
    backClick = backClick
)

internal class NotificationComponentImpl(
    componentContext: ComponentContext,
    private val backClick: () -> Unit
): NotificationComponent, ComponentContext by componentContext, KoinComponent {

    override fun onBackClicked() = backClick()

    private val _switchSchedule = mutableStateOf(false)
    override val switchSchedule: State<Boolean> = _switchSchedule

    private val _switchChanges = mutableStateOf(false)
    override val switchChanges: State<Boolean> = _switchChanges

    override fun onSwitchScheduleState(state: Boolean) {
        _switchSchedule.value = state
    }

    override fun onSwitchChangesState(state: Boolean) {
        _switchChanges.value = state
    }
}