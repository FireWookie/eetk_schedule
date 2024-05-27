package ru.eetk.settings.design.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.components.layout.EETKColumn
import ru.eetk.resources.EetkRes
import ru.eetk.settings.design.component.DesignComponent

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