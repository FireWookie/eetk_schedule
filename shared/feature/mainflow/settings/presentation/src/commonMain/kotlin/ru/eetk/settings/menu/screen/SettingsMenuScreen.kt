package ru.eetk.settings.menu.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.about_app
import eetk_app.shared.compose.resources.generated.resources.design
import eetk_app.shared.compose.resources.generated.resources.notification
import eetk_app.shared.compose.resources.generated.resources.settings
import eetk_app.shared.compose.resources.generated.resources.settings_profile
import org.jetbrains.compose.resources.stringResource
import ru.eetk.components.buttons.PrimaryEETKButton
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.components.layout.TopappBar

import ru.eetk.settings.menu.component.SettingsMenuComponent


@Composable
internal fun SettingsMenuScreen(
    component: SettingsMenuComponent
) {
    Scaffold(
        topBar = { TopappBar(text = stringResource(Res.string.settings)) },
        content = { insetPadding -> SettingsMenuContent(component = component, insetPadding = insetPadding) }
    )
}

@Composable
private fun SettingsMenuContent(
    component: SettingsMenuComponent,
    insetPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val icons = Icons.Outlined
    CenteredColumn(
        modifier = Modifier
            .padding(insetPadding)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        PrimaryEETKButton(
            text = stringResource(Res.string.notification),
            icon = icons.Notifications,
            onClick = component::onNotificationClick
        )
        PrimaryEETKButton(
            text = stringResource(Res.string.design),
            icon = icons.Palette,
            onClick = component::onDesignClick
        )
        PrimaryEETKButton(
            text = stringResource(Res.string.settings_profile),
            icon = icons.Person,
            onClick = component::onProfileClick
        )
        PrimaryEETKButton(
            text = stringResource(Res.string.about_app),
            icon = icons.Info,
            onClick = {}
        )
    }
}