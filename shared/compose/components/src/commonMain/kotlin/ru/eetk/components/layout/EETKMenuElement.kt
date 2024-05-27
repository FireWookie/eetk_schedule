package ru.eetk.components.layout

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.eetk.components.dropdownmenu.DropDownMenu
import ru.eetk.components.dropdownmenu.DropDownMenuAnimatedIcon
import ru.eetk.components.dropdownmenu.DropDownMenuBox

@Composable
fun EETKMenuElement(
    text: String,
    modifier: Modifier = Modifier,
    leadingContent: @Composable () -> Unit = {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
    },
    trailingContent: @Composable () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 10.dp).then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        leadingContent()
        trailingContent()
    }
}

@Composable
fun EETKMenuSwitch(
    text: String,
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    EETKMenuElement(
        text = text,
        modifier = modifier,
    ) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun <T> EETKMenuDropDown(
    title: String,
    expanded: Boolean,
    selectedItem: T,
    onChangeItem: (T) -> Unit,
    listItems: List<T>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    itemConvertText: @Composable (T) -> String
) {
    DropDownMenuBox(
        title = title,
        expanded = expanded,
        itemConvertText = itemConvertText,
        listItems = listItems,
        selectedItem = selectedItem,
        onChangeItem = onChangeItem,
        onClick = onClick,
        ddmField = {
            EETKMenuElement(
                text = title,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable(onClick = onClick)
                    .then(modifier),
            ) {
                DropDownMenuAnimatedIcon(
                    expanded = expanded,
                    text = itemConvertText(selectedItem)
                )
            }
        }
    )


}