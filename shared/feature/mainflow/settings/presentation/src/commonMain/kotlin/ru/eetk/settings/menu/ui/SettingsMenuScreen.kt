package ru.eetk.settings.menu.ui

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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.cards.EETKSettingCard
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.layout.TitleAppBar
import ru.eetk.resources.EetkRes
import ru.eetk.settings.menu.component.SettingsMenuComponent


@Composable
internal fun SettingsMenuScreen(
    component: SettingsMenuComponent
) {
    Scaffold(
        topBar = { TitleAppBar(text = stringResource(EetkRes.strings.settings)) },
        content = { insetPadding -> SettingsMenuContent(component = component, insetPadding = insetPadding.calculateTopPadding()) }
    )
}

@Composable
private fun SettingsMenuContent(
    component: SettingsMenuComponent,
    insetPadding: Dp
) {
    val icons = Icons.Outlined
    EETKColumn(
        insetPadding = insetPadding,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        EETKSettingCard(
            text = stringResource(EetkRes.strings.notification),
            icon = icons.Notifications,
            onClick = component::onNotificationClick
        )
        EETKSettingCard(
            text = stringResource(EetkRes.strings.design),
            icon = icons.Palette,
            onClick = component::onDesignClick
        )
        EETKSettingCard(
            text = stringResource(EetkRes.strings.settings_profile),
            icon = icons.Person,
            onClick = component::onProfileClick
        )
        EETKSettingCard(
            text = stringResource(EetkRes.strings.about_app),
            icon = icons.Info,
            onClick = {}
        )
    }
}