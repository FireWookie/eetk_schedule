package ru.eetk.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 5.dp).then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        leadingContent()
        trailingContent()
    }
}

@Composable
fun EETKMenuSwitchElement(
    text: String,
    modifier: Modifier = Modifier,
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit
) {
    EETKMenuElement(
        text = text,
        modifier = modifier,
    ) {
        Switch(
            checked = checked.value,
            onCheckedChange = onCheckedChange
        )
    }
}