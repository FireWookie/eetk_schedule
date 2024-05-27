package ru.eetk.settings.notification.component

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.Cancellation
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.rx.observer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.arkivanov.mvikotlin.extensions.coroutines.states
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import ru.eetk.settings.notification.component.store.NotificationStore
import ru.eetk.settings.notification.component.store.NotificationStore.*
import ru.eetk.theme.util.BaseComponent

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
): NotificationComponent, BaseComponent(componentContext) {

    override val notificationStore: NotificationStore = instanceKeeper.getStore(::get)
    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: StateFlow<NotificationStore.State> = notificationStore.stateFlow

    override fun onBackClicked() = backClick()

    override fun onSwitchScheduleState(state: Boolean) {
        notificationStore.accept(Intent.ChangeNotificationSchedule)
    }

    override fun onSwitchChangesState(state: Boolean) {
        notificationStore.accept(Intent.ChangeNotificationChanges)
    }
}