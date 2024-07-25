package ru.eetk.schedule.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.eetk.schedule.changes.component.buildChangesComponent
import ru.eetk.schedule.root.component.utils.Screen
import ru.eetk.schedule.schedule.component.buildScheduleComponent
import ru.eetk.theme.util.BaseComponent

fun buildScheduleRootComponent(
    componentContext: ComponentContext,
): ScheduleRootComponent = ScheduleRootComponentImpl(
    componentContext = componentContext
)
@OptIn(ExperimentalDecomposeApi::class)
class ScheduleRootComponentImpl(
    componentContext: ComponentContext
): ScheduleRootComponent, BaseComponent(componentContext), BackHandlerOwner {
//    private val navigation = PagesNavigation<Config>()

    private val navigation = PagesNavigation<ScheduleRootComponent.Config>()


    override val configs: List<ScheduleRootComponent.Config>
        get() = listOf(ScheduleRootComponent.Config.Schedule, ScheduleRootComponent.Config.Changes)

    private val _pages = this.childPages(
        source = navigation,
        serializer = ScheduleRootComponent.Config.serializer(),
        initialPages = {
            Pages(
                items = configs,
                selectedIndex = Screen.Schedule.index,
            )
        },
        childFactory = ::createChildPageFactor
    )
    override val pages: Value<ChildPages<*, ScheduleRootComponent.Segments>>
        get() = _pages

    private fun createChildPageFactor(
        config: ScheduleRootComponent.Config,
        componentContext: ComponentContext,
    ): ScheduleRootComponent.Segments {
        return when (config) {
            ScheduleRootComponent.Config.Schedule -> ScheduleRootComponent.Segments.Schedule(
                component = buildScheduleComponent(
                    componentContext = componentContext,
                )
            )
            ScheduleRootComponent.Config.Changes -> ScheduleRootComponent.Segments.Changes(
                component = buildChangesComponent(
                    componentContext = componentContext
                )
            )
        }
    }

    override fun changeSegment(index: Int) {
        navigation.select(index = index)
    }
}