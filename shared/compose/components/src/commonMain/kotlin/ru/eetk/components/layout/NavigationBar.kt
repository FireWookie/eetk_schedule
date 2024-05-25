package ru.eetk.components.layout

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

private val tonalElevation = 0.dp

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
//    val containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(tonalElevation)

    androidx.compose.material3.NavigationBar(
        modifier = modifier,
        content = content
    )
}

@Composable
fun RowScope.NavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    enabled: Boolean = true
) {

    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        label = label,
        enabled = enabled
    )
}

@Composable
fun NavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    enabled: Boolean = true
) {
    val containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(tonalElevation)

    androidx.compose.material3.NavigationRailItem(
        colors = NavigationRailItemDefaults.colors(
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                alpha = 0.45f
            ),
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                alpha = 0.45f
            ),
            indicatorColor = containerColor,
        ),
        selected = selected,
        onClick = onClick,
        icon = icon,
        enabled = enabled
    )
}