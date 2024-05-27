package ru.eetk.components.dropdownmenu

import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun <T> DropDownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    selectedItem: T,
    onChangeItem: (T) -> Unit,
    listItems: List<T>,
    itemConvertText: @Composable (T) -> String
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        listItems.forEach { label ->
            DDMItem(
                text = itemConvertText(label),
                onClick = { onChangeItem(label) },
                selected = selectedItem == label
            )
        }
    }
}

@Composable
private fun DDMItem(text: String, onClick: () -> Unit, selected: Boolean) {
    DropdownMenuItem(
        text = { Text(text = text) },
        onClick = onClick,
        modifier = if (selected) Modifier.background(Color.Black.copy(alpha = 0.1f)) else Modifier
    )
}