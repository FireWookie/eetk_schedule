package ru.eetk.mainflow.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.launch
import ru.eetk.coroutines.coroutineScope

fun buildMainFlowComponent(
    componentContext: ComponentContext
): MainFlowComponent = MainFlowComponentImpl(
    componentContext = componentContext
)

@OptIn(ExperimentalDecomposeApi::class)
internal class MainFlowComponentImpl(
    private val componentContext: ComponentContext,
): ComponentContext by componentContext, MainFlowComponent {

    private val navigation = PagesNavigation<MainTabNavigation>()

    private val coroutineScope = coroutineScope()

    override fun changeTab(index: Int) {
        coroutineScope.launch {
            navigation.select(index)
        }
    }

    override val pages: Value<ChildPages<*, MainFlowComponent.MainTabs>> = this.childPages(
        source = navigation,
        initialPages = {
            Pages(
                items = configs,
                selectedIndex = 0
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
                Unit
            )

            MainTabNavigation.Review -> MainFlowComponent.MainTabs.Review(
                Unit
            )

            MainTabNavigation.Settings -> MainFlowComponent.MainTabs.Settings(
                Unit
            )
        }
    }

}