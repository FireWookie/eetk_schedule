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
internal fun DropDownMenu(
    expanded: State<Boolean>,
    desc: String = "",
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    selectedItem: State<String>,
    onChangeItem: (String) -> Unit,
    listItems: List<String>,
) {
    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        listItems.forEach { label ->
            DDMItem(
                text = "$label $desc",
                onClick = { onChangeItem(label) },
                selected = selectedItem.value == label
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