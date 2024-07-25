package ru.eetk.review.root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.eetk.review.auth.component.ReviewAuthComponent

interface ReviewRootComponent {
    val childStack: Value<ChildStack<*, Child>>

    fun onBackClicked()

    sealed class Child {
        class Auth(val component: ReviewAuthComponent): Child()
    }
}