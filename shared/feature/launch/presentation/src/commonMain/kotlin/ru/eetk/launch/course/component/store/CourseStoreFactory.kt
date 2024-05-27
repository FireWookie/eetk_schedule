package ru.eetk.launch.course.component.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapperScope
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.eetk.launch.course.component.store.CourseStore.*
import ru.eetk.persistent.launch.setLaunchInfo

internal class CourseStoreFactory(
    private val storeFactory: StoreFactory,
    private val dataStore: DataStore<Preferences>
) {


    fun create(): CourseStore =
        object: CourseStore, Store<Intent, State, Nothing> by storeFactory.create(
                    name= STORE_NAME,
                    bootstrapper = SimpleBootstrapper(Unit),
                    initialState= State(),
                    executorFactory = coroutineExecutorFactory(Dispatchers.Main) {
                        onIntent<Intent.ChangeSelectedCourse> {
                            dispatch(Message.SelectCourse(item = it.item))
                        }
                        onIntent<Intent.ChangeExpanded> {
                            dispatch(Message.ChangeExpanded)
                        }
                        onIntent<Intent.SaveInfoLaunch> { state ->
                            launch {
                                dataStore.edit {
                                    it.setLaunchInfo(
                                        college = state.college,
                                        course = state.course
                                    )
                                }
                            }
                        }
                    },
                    reducer = ReducerImpl
                ) {}

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