package ru.eetk.schedule.root.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.pages.Pages
import com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.pages.ChildPages
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.layout.TitleAppBar
import ru.eetk.components.segmetedpicker.EETKSegmentedPickerSegment
import ru.eetk.resources.EetkRes
import ru.eetk.schedule.changes.ui.ChangesScreen
import ru.eetk.schedule.root.component.ScheduleRootComponent
import ru.eetk.schedule.root.component.utils.Screen
import ru.eetk.schedule.schedule.screen.ScheduleScreen


@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun ScheduleRootScreen(
    component: ScheduleRootComponent,
) {
    val pages by component.pages.subscribeAsState()
    val listSegments = remember { listOf(Screen.Schedule, Screen.Changes) }

    Scaffold(
        topBar = { TitleAppBar(text = stringResource(EetkRes.strings.schedule)) },
        content = { insetPadding ->
            ScheduleRootScreenContent(
                pages = pages,
                list = listSegments,
                onSelectSegment = component::changeSegment,
                insetPadding = insetPadding.calculateTopPadding()
            )
        }
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalDecomposeApi::class)
@Composable
private fun ScheduleRootScreenContent(
    pages: ChildPages<*, ScheduleRootComponent.Segments>,
    list: List<Screen>,
    onSelectSegment: (Int) -> Unit,
    insetPadding: Dp,
) {
    EETKColumn(
        topAppBarPadding = insetPadding,
        modifier = Modifier,
        isHorizontalPadding = false
    ) {
        EETKSegmentedPicker(
            iconSelectedSegment = Icons.Outlined.Check,
            listSegments = list,
            selectedSegment = pages.selectedIndex,
            onChangeSegment = onSelectSegment
        )
        Pages(
            pages = pages,
            onPageSelected = onSelectSegment,
            scrollAnimation = PagesScrollAnimation.Custom(
                spec = spring(
                    stiffness = Spring.StiffnessLow
                )
            )
        ) { _, page ->
            when (page) {
                is ScheduleRootComponent.Segments.Schedule -> ScheduleScreen(page.component)
                is ScheduleRootComponent.Segments.Changes -> ChangesScreen(page.component)
            }
        }
    }
}

@Composable
private fun EETKSegmentedPicker(
    iconSelectedSegment: ImageVector?,
    selectedSegment: Int,
    listSegments: List<Screen>,
    onChangeSegment: (Int) -> Unit,
) {
    val shape = MaterialTheme.shapes.extraLarge
    Row(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(shape = shape)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = shape
            )
    ) {
        listSegments.forEach { segment ->
            EETKSegmentedPickerSegment(
                icon = iconSelectedSegment,
                title = stringResource(segment.labelId),
                selected = selectedSegment == segment.index,
                onClick = { onChangeSegment(segment.index) }
            )
            VerticalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}