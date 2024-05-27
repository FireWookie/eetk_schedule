package ru.eetk.components.dropdownmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Composable кнопка EETKButton с background surfaceContainerHighest
 * @param modifier модификатор который можно повесить на кнопку
 * @param text параметр который отвечает за отображение текста внутри кнопки, тип String
 * @param icon иконка которая распологается рядом с текстом, тип ImageVector
 * @param onClick возвращает event при нажатии на кнопку
 * */

@Composable
fun DropDownMenuBox(
    title: String,
    desc: String,
    expanded: State<Boolean>,
    selectedItem: State<String>,
    listItems: List<String>,
    onClick: () -> Unit,
    onDismissRequest: () -> Unit,
    onChangeItem: (String) -> Unit,
    ddmField: @Composable () -> Unit = {
        DropDownMenuField(
            title = title,
            desc = desc,
            expanded = expanded,
            selectedItem = selectedItem,
            onClick = onClick
        )
    },
    ddm: @Composable () -> Unit = {
        DropDownMenu(
            expanded = expanded,
            desc = desc,
            onDismissRequest = onDismissRequest,
            onChangeItem = onChangeItem,
            selectedItem = selectedItem,
            listItems = listItems
        )
    }
) {
    Column(modifier = Modifier.fillMaxWidth().height(50.dp))
    {
        ddmField()
        Row(modifier = Modifier.padding(top = 10.dp).align(Alignment.End))
        {
            ddm()
        }
    }
}
