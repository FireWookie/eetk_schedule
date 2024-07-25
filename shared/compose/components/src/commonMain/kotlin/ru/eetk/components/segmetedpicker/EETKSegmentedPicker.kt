package ru.eetk.components.segmetedpicker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.EETKSegmentedPickerSegment(
    icon: ImageVector?,
    title: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val color = if (selected) MaterialTheme.colorScheme.secondaryContainer else Color.Unspecified
    val animatedColor by animateColorAsState(targetValue = color)
    Row(
        modifier = Modifier
            .weight(0.5f)
            .fillMaxHeight()
            .background(color = animatedColor)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon !== null) {
            AnimatedVisibility(selected){
                Icon(
                    imageVector = icon,
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.size(18.dp),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall
        )
    }
}