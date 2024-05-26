package ru.eetk.launch.course.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.btn_continue
import eetk_app.shared.compose.resources.generated.resources.course
import eetk_app.shared.compose.resources.generated.resources.select_course
import org.jetbrains.compose.resources.stringResource
import ru.eetk.components.buttons.DDMBox
import ru.eetk.components.buttons.PrimaryButton
import ru.eetk.components.buttons.PrimaryBackButton
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.launch.course.component.SelectCourseComponent

@Composable
internal fun SelectCourseScreen(component: SelectCourseComponent) {
    PrimaryBackButton(
        onClick = component::onBackClicked,
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
            text = stringResource(Res.string.select_course),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge
        )
        DDMBox(
            title = stringResource(Res.string.course),
            desc = stringResource(Res.string.course).lowercase(),
            selectedItem = component.selectedItem,
            expanded = component.expanded,
            onDismissRequest = component::onDDMDismissRequest,
            onChangeItem = component::onDDMChangeItem,
            onClick = component::onDDMClicked
        )
        PrimaryButton(
            text = stringResource(Res.string.btn_continue),
            onClick = component::openMainFlow,
        )
    }
}