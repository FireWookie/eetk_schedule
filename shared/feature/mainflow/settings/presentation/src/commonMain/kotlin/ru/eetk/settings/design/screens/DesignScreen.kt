package ru.eetk.settings.design.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.dark_theme
import eetk_app.shared.compose.resources.generated.resources.design
import eetk_app.shared.compose.resources.generated.resources.dynamic_colors
import org.jetbrains.compose.resources.stringResource
import ru.eetk.components.buttons.SettingsPrimaryDropDownMenu
import ru.eetk.components.buttons.SettingsPrimarySwitch
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.settings.design.component.DesignComponent

@Composable
internal fun DesignScreen(component: DesignComponent) {
    Scaffold(
        topBar = {
            CenteredTopAppBar(
                text = stringResource(Res.string.design),
                onBackClicked = component::onBackClicked
            )
        },
        content = { insetPadding -> DesignScreenComponent(component = component, insetPadding = insetPadding) }
    )
}

@Composable
private fun DesignScreenComponent(
    component: DesignComponent,
    insetPadding: PaddingValues,
) {
    val test = mutableStateOf(true)
    Column(
        modifier = Modifier.padding(insetPadding).padding(top = 16.dp).padding(horizontal = 16.dp)
    ) {
        SettingsPrimarySwitch(text = stringResource(Res.string.dynamic_colors), test)
        SettingsPrimaryDropDownMenu(text = stringResource(Res.string.dark_theme))
    }
}