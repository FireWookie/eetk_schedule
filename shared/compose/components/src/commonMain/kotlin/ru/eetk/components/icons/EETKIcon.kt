package ru.eetk.components.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

private val Size = 140.dp

@Composable
fun EETKIcon(
    icon: Painter
) {
    val shape = MaterialTheme.shapes.extraLarge
    Box(
        modifier = Modifier
            .size(Size)
            .clip(shape = shape)
            .border(1.dp, color = MaterialTheme.colorScheme.outline, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .offset(x = 5.dp)
                .padding(10.dp)
                .fillMaxSize()
        )
    }

}