package ru.eetk.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun EETKShapes(modifier: Modifier = Modifier): Shapes {
    val shapes = Shapes(
        large = RoundedCornerShape(20.dp)
    )
    return shapes
}