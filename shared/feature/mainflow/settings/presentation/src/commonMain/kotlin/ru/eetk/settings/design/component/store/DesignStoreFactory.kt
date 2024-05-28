package ru.eetk.settings.design.component.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.eetk.datastore.edit
import ru.eetk.persistent.appearance.Theme
import ru.eetk.persistent.appearance.appTheme
import ru.eetk.persistent.appearance.updateAppTheme
import ru.eetk.settings.design.component.store.DesignStore.*

internal class DesignStoreFactory(
    private val storeFactory: StoreFactory,
    private val dataStore: DataStore<Preferences>
) {
    fun create(): DesignStore =
        object: DesignStore, Store<Intent, State, Nothing> by storeFactory.create(
            name= STORE_NAME,
            bootstrapper = SimpleBootstrapper(Unit),
            initialState= State(),
            executorFactory = coroutineExecutorFactory(Dispatchers.Main) {
                onAction<Unit> {
                    launch {
                        val theme = dataStore.data.first().appTheme
                        dispatch(Message.SelectThemeByFilter(theme = theme))
                    }
                }
                onIntent<Intent.ChangeDynamicColors> {
                    dispatch(Message.ChangeDynamicColors)
                }

                onIntent<Intent.ChangeExpanded> {
                    dispatch(Message.ChangeExpanded)
                }
                onIntent<Intent.ChangeSelectedTheme> {
                    launch {
                        dataStore.edit {
                            this.updateAppTheme(it.theme.first.theme)
                        }
                        dispatch(Message.SelectTheme(theme = it.theme))
                    }
                }
            },
            reducer = ReducerImpl
        ) {}

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
}