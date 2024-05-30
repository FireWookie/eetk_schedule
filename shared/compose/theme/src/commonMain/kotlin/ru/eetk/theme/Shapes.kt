package ru.eetk.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


private val Large = 20.dp
private val ExtraLarge = 40.dp


@Composable
internal fun EETKShapes(): Shapes {
    return Shapes(
        large = RoundedCornerShape(Large),
        extraLarge = RoundedCornerShape(ExtraLarge)
    )
}