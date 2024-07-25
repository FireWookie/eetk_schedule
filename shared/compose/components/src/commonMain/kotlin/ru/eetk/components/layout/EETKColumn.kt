package ru.eetk.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun EETKColumn(
    modifier: Modifier = Modifier,
    topAppBarPadding: Dp = 0.dp,
    isFillMaxSize: Boolean = true,
    isHorizontalPadding: Boolean = true,
    isTopPadding: Boolean = true,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable (ColumnScope.() -> Unit),
) {
    val mod: Modifier = if (isFillMaxSize) {
        Modifier.fillMaxSize()
    } else {
        Modifier
    }
    val paddingModifier = mod
        .padding(top = if (isTopPadding) topAppBarPadding + 16.dp else topAppBarPadding)
        .padding(horizontal = if (isHorizontalPadding) 16.dp else 0.dp)

    Column(
        modifier = Modifier
            .then(paddingModifier)
            .then(modifier),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}