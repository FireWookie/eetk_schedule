package ru.eetk.launch.course.component.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.eetk.launch.course.component.store.CourseStore.Intent
import ru.eetk.launch.course.component.store.CourseStore.Label
import ru.eetk.launch.course.component.store.CourseStore.Message
import ru.eetk.launch.course.component.store.CourseStore.State
import ru.eetk.persistent.launch.setLaunchInfo

internal class CourseStoreFactory(
    private val storeFactory: StoreFactory,
) {


    fun create(): CourseStore =
        object: CourseStore, Store<Intent, State, Label> by storeFactory.create(
                    name= STORE_NAME,
                    bootstrapper = BootstrapperImpl(),
                    initialState= State(),
                    executorFactory = ::ExecutorImpl,
                    reducer = ReducerImpl
                ) {}


    private sealed interface Action

    private class BootstrapperImpl: CoroutineBootstrapper<Action>() {
        override fun invoke() {

        }

    }

    private class ExecutorImpl: KoinComponent, CoroutineExecutor<Intent, Action, State, Message, Label>() {
        private val dataStore: DataStore<Preferences> by inject()

        override fun executeIntent(intent: Intent) {
            when(intent){
                Intent.ChangeExpanded -> dispatch(Message.ChangeExpanded)
                is Intent.ChangeSelectedCourse -> dispatch(
                    Message.SelectCourse(item = intent.item)
                )
                is Intent.SaveInfoLaunch -> scope.launch {
                    val state = state()
                    dataStore.edit {
                        it.setLaunchInfo(
                            course = state.selectedCourse,
                            college = intent.college
                        )
                    }
                    publish(Label.OpenMainFlow)
                }
            }
        }
    }

    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when (msg) {
                is Message.SelectCourse -> copy(courseItems = msg.item, expanded = false)
                Message.ChangeExpanded -> copy(expanded = !expanded)
            }
    }


    private companion object {
        private const val STORE_NAME = "Course Store"
    }
}