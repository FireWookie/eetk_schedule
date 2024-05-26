package ru.eetk.settings.menu.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.buttons.PrimaryEETKButton
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.resources.EETKPack
import ru.eetk.resources.EetkRes
import ru.eetk.resources.eetkpack.Info
import ru.eetk.resources.eetkpack.Notification
import ru.eetk.resources.eetkpack.Palette
import ru.eetk.resources.eetkpack.Person

import ru.eetk.settings.menu.component.SettingsMenuComponent


@Composable
internal fun SettingsMenuScreen(
    component: SettingsMenuComponent
) {
    CenteredColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrimaryEETKButton(
            text = stringResource(EetkRes.strings.notification),
            icon = EETKPack.Notification,
            onClick = component::onNotificationClick
        )
        PrimaryEETKButton(
            text = stringResource(EetkRes.strings.design),
            icon = EETKPack.Palette,
            onClick = component::onDesignClick
        )
        PrimaryEETKButton(
            text = stringResource(EetkRes.strings.settings_profile),
            icon = EETKPack.Person,
            onClick = component::onProfileClick
        )
        PrimaryEETKButton(
            text = stringResource(EetkRes.strings.about_app),
            icon = EETKPack.Info,
            onClick = {}
        )
    }
}