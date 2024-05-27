package ru.eetk.settings.profile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.components.layout.EETKColumn
import ru.eetk.resources.EetkRes
import ru.eetk.settings.design.component.DesignComponent
import ru.eetk.settings.profile.component.ProfileComponent

@Composable
internal fun ProfileScreen(component: ProfileComponent) {
    Scaffold(
        topBar = {
            CenteredTopAppBar(
                text = stringResource(EetkRes.strings.settings_profile),
                onBackClicked = component::onBackClicked
            )
        },
        content = { insetPadding ->
            ProfileScreenContent(
                component = component,
                insetPadding = insetPadding
            )
        }
    )
}

@Composable
fun ProfileScreenContent(
    component: ProfileComponent,
    insetPadding: PaddingValues,
) {
    EETKColumn (
        insetPadding = insetPadding
    ) {}
}