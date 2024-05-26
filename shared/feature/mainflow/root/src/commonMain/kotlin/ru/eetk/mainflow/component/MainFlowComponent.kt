package ru.eetk.mainflow.component

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import models.SelectedTab
import ru.eetk.review.root.component.ReviewRootComponent
import ru.eetk.schedule.component.ScheduleComponent
import ru.eetk.settings.root.component.SettingsRootComponent

interface MainFlowComponent {
    fun changeTab(index: Int)

    @OptIn(ExperimentalDecomposeApi::class)
    val pages: Value<ChildPages<*, MainTabs>>
    val configs: List<MainTabNavigation>

    val eventFlow: MutableSharedFlow<SelectedTab>

    sealed interface MainTabs {
        class Schedule(val component: ScheduleComponent): MainTabs
        class Review(val component: ReviewRootComponent): MainTabs
        class Settings(val component: SettingsRootComponent): MainTabs
    }
}