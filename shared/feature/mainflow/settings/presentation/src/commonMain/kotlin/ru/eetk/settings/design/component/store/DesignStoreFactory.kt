package ru.eetk.settings.design.component.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.Dispatchers
import ru.eetk.persistent.appearance.Theme
import ru.eetk.settings.design.component.store.DesignStore.*

internal class DesignStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): DesignStore =
        object: DesignStore, Store<Intent, State, Nothing> by storeFactory.create(
            name= STORE_NAME,
            bootstrapper = SimpleBootstrapper(Unit),
            initialState= State(),
            executorFactory = coroutineExecutorFactory(Dispatchers.Main) {
                onIntent<Intent.ChangeDynamicColors> {
                    dispatch(Message.ChangeDynamicColors)
                }

                onIntent<Intent.ChangeExpanded> {
                    dispatch(Message.ChangeExpanded)
                }
                onIntent<Intent.ChangeSelectedTheme> {
                    dispatch(Message.SelectTheme(theme = it.theme))
                }
            },
            reducer = ReducerImpl
        ) {}

    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when(msg) {
                Message.ChangeDynamicColors -> copy(dynamicColors = !dynamicColors)
                Message.ChangeExpanded -> copy(expanded = !expanded)
                is Message.SelectTheme -> copy(themeItems = msg.theme, expanded = false)
            }
    }
    private companion object {
        private const val STORE_NAME = "Design Store"
    }
}