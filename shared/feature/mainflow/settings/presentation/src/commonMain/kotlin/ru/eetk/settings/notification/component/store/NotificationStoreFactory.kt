package ru.eetk.settings.notification.component.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import kotlinx.coroutines.Dispatchers
import ru.eetk.settings.notification.component.store.NotificationStore.*

internal class NotificationStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): NotificationStore =
        object: NotificationStore, Store<Intent, State, Nothing> by storeFactory.create(
            name= STORE_NAME,
            bootstrapper = SimpleBootstrapper(Unit),
            initialState= State(),
            executorFactory = coroutineExecutorFactory(Dispatchers.Main) {
                onIntent<Intent.ChangeNotificationSchedule> {
                    dispatch(Message.ChangeNotificationSchedule)
                }

                onIntent<Intent.ChangeNotificationChanges> {
                    dispatch(Message.ChangeNotificationChanges)
                }
            },
            reducer = ReducerImpl
        ) {}

    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when(msg) {
                Message.ChangeNotificationChanges -> copy(notificationByChanges = !notificationByChanges)
                Message.ChangeNotificationSchedule -> copy(notificationBySchedule = !notificationBySchedule)
            }
    }
    private companion object {
        private const val STORE_NAME = "Notification Store"
    }
}