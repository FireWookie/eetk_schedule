package ru.eetk.schedule.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.layout.TitleAppBar
import ru.eetk.components.segmetedpicker.EETKSegmentedPicker
import ru.eetk.resources.EetkRes
import ru.eetk.schedule.component.ScheduleComponent

@Composable
fun ScheduleScreen(component: ScheduleComponent) {
    Scaffold(
        topBar = { TitleAppBar(text = stringResource(EetkRes.strings.schedule)) },
        content = { insetPadding -> ScheduleScreenContent(component = component, insetPadding = insetPadding.calculateTopPadding()) }
    )
}

@Composable
fun ScheduleScreenContent(
    component: ScheduleComponent,
    insetPadding: Dp
) {
    val state by component.stateFlow.collectAsState()
    EETKColumn(
        insetPadding = insetPadding,
    ) {
        EETKSegmentedPicker(
            iconSelectedSegment = Icons.Outlined.Check,
            listSegments = state.segments,
            selectedSegment = state.selectedSegment,
            onChangeSegment = component::onChangeSegment,
            segmentConvertText = { stringResource(resource = it.second) }
        )
    }
}