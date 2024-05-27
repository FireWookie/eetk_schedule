package ru.eetk.settings.design.screens

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
import ru.eetk.settings.notification.component.NotificationComponent

@Composable
internal fun DesignScreen(component: DesignComponent) {
    Scaffold(
        topBar = {
            CenteredTopAppBar(
                text = stringResource(EetkRes.strings.design),
                onBackClicked = component::onBackClicked
            )
        },
        content = { insetPadding ->
            DesignScreenContent(
                component = component,
                insetPadding = insetPadding
            )
        }
    )
}

@Composable
fun DesignScreenContent(
    component: DesignComponent,
    insetPadding: PaddingValues,
) {
    EETKColumn (
        insetPadding = insetPadding
    ) {}
}