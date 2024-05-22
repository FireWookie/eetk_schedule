package ru.eetk.launch.course.store

import com.arkivanov.mvikotlin.core.store.Store

interface CourseStore: Store<CourseStore.Intent, CourseStore.State, Nothing> {
    sealed interface Intent

    sealed interface Message

    data class State(val selectedCourse: Int = 1)
}