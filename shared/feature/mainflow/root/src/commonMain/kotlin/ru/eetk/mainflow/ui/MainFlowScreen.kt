package ru.eetk.mainflow.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.pages.ChildPages
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.NavigationBar
import ru.eetk.components.layout.NavigationBarItem
import ru.eetk.mainflow.component.MainFlowComponent
import ru.eetk.mainflow.component.utils.Screen
import ru.eetk.review.root.screen.ReviewRootScreen
import ru.eetk.schedule.root.ui.ScheduleRootScreen
import ru.eetk.settings.root.ui.SettingsRootScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun MainFlowScreen(component: MainFlowComponent) {
    val pages by component.pages.subscribeAsState()
    Scaffold(
        content = { MainFlowContent(pages = pages, it) },
        bottomBar = {
            BottomBarContent(
                pages = pages,
                onSelectTab = component::changeTab
            )
        }
    )
}

@OptIn(ExperimentalDecomposeApi::class)
@Composable
internal fun MainFlowContent(pages: ChildPages<*, MainFlowComponent.MainTabs>, padding: PaddingValues) {
    Box(
        Modifier.padding(bottom = padding.calculateBottomPadding())
    ) {
        when (val page = pages.items[pages.selectedIndex].instance) {
            is MainFlowComponent.MainTabs.Review -> ReviewRootScreen(page.component)
            is MainFlowComponent.MainTabs.Schedule -> ScheduleRootScreen(page.component)
            is MainFlowComponent.MainTabs.Settings -> SettingsRootScreen(page.component)
            null -> {}
        }
    }
}


@OptIn(ExperimentalDecomposeApi::class)
@Composable
internal fun BottomBarContent(
    pages: ChildPages<*, MainFlowComponent.MainTabs>,
    onSelectTab: (Int) -> Unit
) {
    val bottomNavItems = remember { listOf(Screen.Schedule, Screen.Review, Screen.Settings) }
    NavigationBar {
        bottomNavItems.forEach { screen ->
            NavigationBarItem(
                selected = pages.selectedIndex == screen.index,
                onClick = { onSelectTab.invoke(screen.index) },
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = {
                    Text(
                        text = stringResource(screen.labelId)
                    )
                }
            )
        }
    }
}

