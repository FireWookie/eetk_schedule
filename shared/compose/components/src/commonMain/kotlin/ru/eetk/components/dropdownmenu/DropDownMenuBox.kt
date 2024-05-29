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


@Composable
fun <T> DropDownMenuBox(
    title: String,
    expanded: Boolean,
    selectedItem: T,
    listItems: List<T>,
    onClick: () -> Unit,
    onChangeItem: (T) -> Unit,
    itemConvertText: @Composable (T) -> String,
    ddmField: @Composable () -> Unit = {
        DropDownMenuField(
            title = title,
            expanded = expanded,
            selectedItem = selectedItem,
            onClick = onClick,
            itemConvertText = itemConvertText
        )
    },
    ddm: @Composable () -> Unit = {
        DropDownMenu(
            expanded = expanded,
            onDismissRequest = onClick,
            onChangeItem = onChangeItem,
            selectedItem = selectedItem,
            listItems = listItems,
            itemConvertText = itemConvertText
        )
    }
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    )
    {
        ddmField()
        Row(
            modifier = Modifier
                .align(Alignment.End)
        ) {
            ddm()
        }
    }
}
