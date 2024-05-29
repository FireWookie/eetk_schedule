package ru.eetk.mainflow.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import ru.eetk.libraries.flow.models.SelectedTab
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.eetk.coroutines.coroutineScope
import ru.eetk.libraries.flow.FlowConstants
import ru.eetk.mainflow.component.utils.Screen
import ru.eetk.mainflow.component.utils.Screen.*
import ru.eetk.review.root.component.buildReviewRootComponent
import ru.eetk.schedule.component.buildScheduleComponent
import ru.eetk.settings.root.component.buildSettingsRootComponent
import ru.eetk.theme.util.BaseComponent


/**
 * Функция для возвращения internal класса MainFlowComponentImpl
 * */
fun buildMainFlowComponent(
    componentContext: ComponentContext
): MainFlowComponent = MainFlowComponentImpl(
    componentContext = componentContext
)


/**
 * Класс MainFlowComponentImpl представляет собой компонент основного flow, в нем происходит навигация по BottomNavigation
 * @param componentContext встроенный контекст decompose функции
 * changeTab представляет собой метод для навигации между экранами в BottomNavigation
 * eventFlow MutableSharedFlow для уведомления feature модулей о том что BottomNavigation был нажат еще раз
 * чтобы они изменили свой экран на root
 * */
@OptIn(ExperimentalDecomposeApi::class)
internal class MainFlowComponentImpl(
    private val componentContext: ComponentContext,
): BaseComponent(componentContext), MainFlowComponent {

    private val navigation = PagesNavigation<MainTabNavigation>()

    override val eventFlow: MutableSharedFlow<SelectedTab> by inject(named(FlowConstants.TAB_FLOW))

    override fun changeTab(index: Int) { // TODO (refactoring func)
        mainScope.launch {
            if (pages.value.selectedIndex == index) {
                when(pages.value.selectedIndex) {
                     Settings.index -> {
                         eventFlow.emit(SelectedTab.SettingsTab)
                     }
                }
            } else {
                navigation.select(index)
            }
        }
    }

    override val pages: Value<ChildPages<*, MainFlowComponent.MainTabs>> = this.childPages(
        source = navigation,
        initialPages = {
            Pages(
                items = configs,
                selectedIndex = Settings.index
            )
        },
        childFactory = ::createChildPageFactor,
        serializer = MainTabNavigation.serializer()
    )
    override val configs: List<MainTabNavigation>
        get() = listOf(
            MainTabNavigation.Schedule,
            MainTabNavigation.Review,
            MainTabNavigation.Settings
        )


    private fun createChildPageFactor(
        tabs: MainTabNavigation,
        componentContext: ComponentContext,
    ): MainFlowComponent.MainTabs {
        return when (tabs) {
            MainTabNavigation.Schedule -> MainFlowComponent.MainTabs.Schedule(
                buildScheduleComponent(componentContext = componentContext)
            )

            MainTabNavigation.Review -> MainFlowComponent.MainTabs.Review(
                buildReviewRootComponent(componentContext = componentContext)
            )

            MainTabNavigation.Settings -> MainFlowComponent.MainTabs.Settings(
                buildSettingsRootComponent(
                    componentContext = componentContext
                )
            )
        }
    }

}