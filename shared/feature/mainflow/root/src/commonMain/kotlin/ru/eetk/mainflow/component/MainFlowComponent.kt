package ru.eetk.mainflow.component

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value

interface MainFlowComponent {
    fun changeTab(index: Int)

    @OptIn(ExperimentalDecomposeApi::class)
    val pages: Value<ChildPages<*, MainTabs>>
    val configs: List<MainTabNavigation>

    sealed interface MainTabs {
        class Schedule(val component: Unit): MainTabs
        class Review(val component: Unit): MainTabs
        class Settings(val component: Unit): MainTabs
    }
}