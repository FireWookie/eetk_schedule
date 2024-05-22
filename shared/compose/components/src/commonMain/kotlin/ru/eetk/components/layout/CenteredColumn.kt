package ru.eetk.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CenteredColumn(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement. Vertical = Arrangement.Center,
    horizontalAlignment: Alignment. Horizontal = Alignment.CenterHorizontally,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}