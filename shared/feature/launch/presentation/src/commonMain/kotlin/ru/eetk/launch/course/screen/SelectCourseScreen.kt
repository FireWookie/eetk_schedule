package ru.eetk.launch.course.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.buttons.PrimaryFilledButton
import ru.eetk.components.buttons.PrimaryBackButton
import ru.eetk.components.dropdownmenu.DropDownMenuBox
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.launch.course.component.SelectCourseComponent
import ru.eetk.resources.EetkRes

@Composable
internal fun SelectCourseScreen(component: SelectCourseComponent) {
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
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.height(120.dp).width(140.dp)
            )
            Text(
                text = stringResource(EetkRes.strings.select_course),
                style = MaterialTheme.typography.headlineLarge
            )
            DropDownMenuBox(
                title = stringResource(EetkRes.strings.course),
                desc = stringResource(EetkRes.strings.course).lowercase(),
                selectedItem = component.selectedItem,
                expanded = component.expanded,
                listItems = component.listCourses,
                onDismissRequest = component::onDDMDismissRequest,
                onChangeItem = component::onDDMChangeItem,
                onClick = component::onDDMClicked
            )
            PrimaryFilledButton(
                text = stringResource(EetkRes.strings.btn_continue),
                modifier = Modifier,
                onClick = component::openMainFlow,
            )
        }
    }
}