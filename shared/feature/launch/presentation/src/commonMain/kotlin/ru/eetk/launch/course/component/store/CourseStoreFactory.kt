package ru.eetk.launch.course.component.store

import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import kotlinx.coroutines.Dispatchers
import ru.eetk.launch.course.component.store.CourseStore.*

internal class CourseStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): CourseStore =
        object: CourseStore, Store<Intent, State, Nothing> by storeFactory.create(
                    name= STORE_NAME,
                    bootstrapper = SimpleBootstrapper(Unit),
                    initialState= State(),
                    executorFactory = coroutineExecutorFactory(Dispatchers.Main) {
                        onAction<Unit> {  }
                        onIntent<Intent.ChangeSelectedCourse> {
                            dispatch(Message.SelectCourse(item = it.item))
                        }
                        onIntent<Intent.ChangeExpanded> {
                            dispatch(Message.ChangeExpanded)
                        }
                    },
                    reducer = ReducerImpl
                ) {}

    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when(msg) {
                is Message.SelectCourse -> copy(courseItems = msg.item, expanded = false)
                Message.ChangeExpanded -> copy(expanded = !expanded)
            }
    }
    private companion object {
        private const val STORE_NAME = "Course Store"
    }
}