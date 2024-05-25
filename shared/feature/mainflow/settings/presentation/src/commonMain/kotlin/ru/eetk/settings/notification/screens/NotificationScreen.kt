package ru.eetk.settings.notification.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.notification
import eetk_app.shared.compose.resources.generated.resources.notification_by_changes
import eetk_app.shared.compose.resources.generated.resources.notification_by_schedule
import org.jetbrains.compose.resources.stringResource
import ru.eetk.components.buttons.SettingsPrimarySwitch
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.settings.notification.component.NotificationComponent

@Composable
internal fun NotificationScreen(
    component: NotificationComponent
) {
    Scaffold(
        topBar = {
            CenteredTopAppBar(
                text = stringResource(Res.string.notification),
                onBackClicked = component::onBackClicked
            )
        },
        content = { insetPadding -> NotificationScreenContent(component = component, insetPadding = insetPadding) }
    )
}

@Composable
private fun NotificationScreenContent(
    component: NotificationComponent,
    insetPadding: PaddingValues,
) {
    val test = mutableStateOf(true)
    Column(
        modifier = Modifier.padding(insetPadding).padding(top = 16.dp).padding(horizontal = 16.dp)
    ) {
        SettingsPrimarySwitch(text = stringResource(Res.string.notification_by_schedule), test)
        SettingsPrimarySwitch(text = stringResource(Res.string.notification_by_changes), test)
    }
}