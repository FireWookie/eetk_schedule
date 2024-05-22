package ru.eetk.launch.course.store

import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import kotlinx.coroutines.Dispatchers

internal class CourseStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): CourseStore =
        object: CourseStore, Store<CourseStore.Intent, CourseStore.State, Nothing> by storeFactory.create(
                    name=STORE_NAME,
                    bootstrapper = SimpleBootstrapper(Unit),
                    initialState=CourseStore.State(),
                    executorFactory = coroutineExecutorFactory(Dispatchers.Main) {
                        onAction<Unit> {  }
                    },
                    reducer = ReducerImpl
                ) {}

    private object ReducerImpl : Reducer<CourseStore.State, CourseStore.Message> {
        override fun CourseStore.State.reduce(msg: CourseStore.Message): CourseStore.State =
            when(msg) {
                else -> copy()
            }
    }
    private companion object {
        private const val STORE_NAME = "Course Store"
    }
}