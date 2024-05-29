package ru.eetk.schedule.component.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import org.koin.core.component.KoinComponent
import ru.eetk.schedule.component.store.ScheduleStore.*

internal class ScheduleStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): ScheduleStore =
        object: ScheduleStore, Store<Intent, State, Nothing> by storeFactory.create(
            name= STORE_NAME,
            bootstrapper = BootstrapperImpl(),
            initialState= State(),
            executorFactory =::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed interface Action

    private class BootstrapperImpl: CoroutineBootstrapper<Action>() {
        override fun invoke() {
        }
    }

    private class ExecutorImpl: KoinComponent,
        CoroutineExecutor<Intent, Action, State, Message, Nothing>()
    {
        override fun executeIntent(intent: Intent) {
            when(intent) {
                is Intent.ChangeSegment -> dispatch(Message.SelectSegment(segment = intent.segment))
            }
        }

    }
    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when(msg) {
                is Message.SelectSegment -> copy(selectedSegment = msg.segment)
            }
    }

    private companion object {
        private const val STORE_NAME = "Schedule Store"
    }
}