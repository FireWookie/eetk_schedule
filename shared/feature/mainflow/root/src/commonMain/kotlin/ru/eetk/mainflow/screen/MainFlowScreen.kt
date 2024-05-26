package ru.eetk.mainflow.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.pages.ChildPages
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.NavigationBar
import ru.eetk.components.layout.NavigationBarItem
import ru.eetk.mainflow.component.MainFlowComponent
import ru.eetk.mainflow.component.utils.Screen
import ru.eetk.review.root.screen.ReviewRootScreen
import ru.eetk.schedule.screen.ScheduleScreen
import ru.eetk.settings.root.screens.SettingsRootScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun MainFlowScreen(component: MainFlowComponent) {
    val pages by component.pages.subscribeAsState()
    Scaffold(
        content = {
            MainFlowContent(pages = pages)
        },
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
internal fun MainFlowContent(pages: ChildPages<*, MainFlowComponent.MainTabs>) {
    Column(
        modifier = Modifier
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
        Box(
            modifier = Modifier.wrapContentHeight()
        ) {
            when (val page = pages.items[pages.selectedIndex].instance) {
                is MainFlowComponent.MainTabs.Review -> ReviewRootScreen(page.component)
                is MainFlowComponent.MainTabs.Schedule -> ScheduleScreen(page.component)
                is MainFlowComponent.MainTabs.Settings -> SettingsRootScreen(page.component)
                null -> {}
            }
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

