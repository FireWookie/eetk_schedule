package ru.eetk.components.dropdownmenu

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
internal fun <T> DropDownMenuField(
    title: String,
    selectedItem: T,
    itemConvertText: @Composable (T) -> String,
    onClick: () -> Unit,
    expanded: Boolean
) {
    val shape = MaterialTheme.shapes.medium
    val selectedColor = if (expanded) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.primary
    val angle = if (expanded) 180f else 0f
    val animatedAngle by animateFloatAsState(angle)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = shape)
            .clickable(onClick = onClick)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.outline, shape = shape)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = title)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemConvertText(selectedItem), color = selectedColor)
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.rotate(animatedAngle),
            tint = selectedColor
        )
    }
}