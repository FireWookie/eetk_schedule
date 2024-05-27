package ru.eetk.launch.course.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.buttons.PrimaryFilledButton
import ru.eetk.components.buttons.PrimaryBackButton
import ru.eetk.components.dropdownmenu.DropDownMenuBox
import ru.eetk.components.icons.PeopleIcon
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.launch.course.component.SelectCourseComponent
import ru.eetk.resources.EetkRes

@Composable
internal fun SelectCourseScreen(component: SelectCourseComponent) {
    val state by component.stateFlow.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)
    ) {
        PrimaryBackButton(
            onClick = component::onBackClicked,
            showBackground = true,
            modifier = Modifier.padding(16.dp).padding(top = 10.dp)
        )
        CenteredColumn(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {
            PeopleIcon()
            Text(
                text = stringResource(EetkRes.strings.select_course),
                style = MaterialTheme.typography.headlineLarge
            )
            DropDownMenuBox(
                title = stringResource(EetkRes.strings.course),
                selectedItem = state.courseItems,
                expanded = state.expanded,
                listItems = state.items,
                onChangeItem = component::onDDMChangeItem,
                onClick = component::onDDMClicked,
                itemConvertText = {
                    "${it.first} ${stringResource(resource = it.second).lowercase()}"
                }
            )
            PrimaryFilledButton(
                text = stringResource(EetkRes.strings.btn_continue),
                modifier = Modifier,
                onClick = component::openMainFlow,
            )
        }
    }
}