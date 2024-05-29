package ru.eetk.components.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun DefaultPhoto(painter: Painter) {
    val shape = MaterialTheme.shapes.extraLarge
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(shape = shape)
            .border(2.dp, MaterialTheme.colorScheme.outlineVariant, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }

}