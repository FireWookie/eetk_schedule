package ru.eetk.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CenteredColumn(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement. Vertical = Arrangement.Center,
    horizontalAlignment: Alignment. Horizontal = Alignment.CenterHorizontally,
    isMaxSize: Boolean = true,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    val mod: Modifier

    if(isMaxSize) {
        mod = modifier.fillMaxSize().padding(horizontal = 16.dp).then(modifier)
    } else {
        mod = modifier.padding(horizontal = 16.dp).then(modifier)
    }
    Column(
        modifier = mod,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}