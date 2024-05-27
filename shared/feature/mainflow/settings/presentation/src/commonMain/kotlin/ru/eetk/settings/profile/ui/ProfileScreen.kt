package ru.eetk.settings.profile.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.components.layout.EETKColumn
import ru.eetk.resources.EetkRes
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
                insetPadding = insetPadding.calculateTopPadding()
            )
        }
    )
}

@Composable
fun ProfileScreenContent(
    component: ProfileComponent,
    insetPadding: Dp,
) {
    EETKColumn (
        insetPadding = insetPadding
    ) {

    }
}