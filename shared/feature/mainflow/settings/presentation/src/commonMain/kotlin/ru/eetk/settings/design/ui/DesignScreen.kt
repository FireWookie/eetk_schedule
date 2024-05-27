package ru.eetk.settings.design.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.dropdownmenu.DropDownMenuBox
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.layout.EETKMenuDropDown
import ru.eetk.components.layout.EETKMenuSwitch
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
                insetPadding = insetPadding.calculateTopPadding(),
            )
        }
    )
}

@Composable
fun DesignScreenContent(
    component: DesignComponent,
    insetPadding: Dp,
) {
    val state by component.stateFlow.collectAsState()
    EETKColumn (
        insetPadding = insetPadding
    ) {
        EETKMenuSwitch(
            text = stringResource(EetkRes.strings.dynamic_colors),
            checked = state.dynamicColors,
            onCheckedChange = component::onChangeDynTheme
        )

        EETKMenuDropDown(
            title = stringResource(EetkRes.strings.dark_theme),
            selectedItem = state.themeItems,
            expanded = state.expanded,
            onClick = component::onThemeClicked,
            listItems = state.items,
            onChangeItem = component::onChangeThemeItem,
            itemConvertText = { stringResource(resource = it) }
        )
    }
}