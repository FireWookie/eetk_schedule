package ru.eetk.settings.notification.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.layout.EETKMenuSwitchElement
import ru.eetk.resources.EetkRes
import ru.eetk.settings.notification.component.NotificationComponent

@Composable
internal fun NotificationScreen(
    component: NotificationComponent
) {
    Scaffold(
        topBar = {
            CenteredTopAppBar(
                text = stringResource(EetkRes.strings.notification),
                onBackClicked = component::onBackClicked
            )
        },
        content = { insetPadding ->
            NotificationScreenContent(
                component = component,
                insetPadding = insetPadding,
            )
        }
    )
}

@Composable
private fun NotificationScreenContent(
    component: NotificationComponent,
    insetPadding: PaddingValues,
) {
    val state by component.state.collectAsState()

    EETKColumn (
        insetPadding = insetPadding
    ) {
        EETKMenuSwitchElement(
            text = stringResource(EetkRes.strings.notification_by_schedule),
            checked = state.notificationBySchedule,
            onCheckedChange = component::onSwitchScheduleState
        )
        EETKMenuSwitchElement(
            text = stringResource(EetkRes.strings.notification_by_changes),
            checked = state.notificationByChanges,
            onCheckedChange = component::onSwitchChangesState
        )
    }
}