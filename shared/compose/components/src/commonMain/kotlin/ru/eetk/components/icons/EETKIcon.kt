package ru.eetk.components.icons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

private val Height = 120.dp
private val Width = 140.dp

@Composable
fun EETKIcon(
    icon: Painter
) {
    Icon(
        painter = icon,
        tint = MaterialTheme.colorScheme.primary,
        contentDescription = null,
        modifier = Modifier
            .height(Height)
            .width(Width)
    )
}