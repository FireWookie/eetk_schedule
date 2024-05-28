package ru.eetk.settings.design.component.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.eetk.datastore.edit
import ru.eetk.persistent.appearance.Theme
import ru.eetk.persistent.appearance.appTheme
import ru.eetk.persistent.appearance.updateAppTheme
import ru.eetk.settings.design.component.store.DesignStore.*

internal class DesignStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): DesignStore =
        object: DesignStore, Store<Intent, State, Nothing> by storeFactory.create(
            name= STORE_NAME,
            bootstrapper = BootstrapperImpl(),
            initialState= State(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}


    private class BootstrapperImpl: CoroutineBootstrapper<Action>() {
        override fun invoke() {
            dispatch(Action.LoadInfo)
        }

    }

    private class ExecutorImpl: KoinComponent, CoroutineExecutor<Intent, Action, State, Message, Nothing>() {

        private val dataStore: DataStore<Preferences> by inject()
        override fun executeIntent(intent: Intent) {
            when(intent) {
                Intent.ChangeDynamicColors -> dispatch(Message.ChangeDynamicColors)
                Intent.ChangeExpanded -> dispatch(Message.ChangeExpanded)
                is Intent.ChangeSelectedTheme -> dispatch(Message.SelectTheme(intent.theme))
            }
        }

        override fun executeAction(action: Action) {
            when(action) {
                Action.LoadInfo -> loadInfoTheme()
            }
        }
        private fun loadInfoTheme() {
            scope.launch {
                val theme = dataStore.data.first().appTheme
                dispatch(Message.SelectThemeByFilter(theme = theme))
            }
        }
    }
    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when(msg) {
                Message.ChangeDynamicColors -> copy(dynamicColors = !dynamicColors)
                Message.ChangeExpanded -> copy(expanded = !expanded)
                is Message.SelectTheme -> copy(selectedTheme = msg.theme, expanded = false)
                is Message.SelectThemeByFilter -> copy(selectedTheme = items.first { it.first == msg.theme })
            }
    }
    private companion object {
        private const val STORE_NAME = "Design Store"
    }

    private sealed interface Action {
        data object LoadInfo: Action
    }
}