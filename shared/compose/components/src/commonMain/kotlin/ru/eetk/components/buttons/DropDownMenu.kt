package ru.eetk.components.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@Composable
fun DDMBox(
    title: String,
    desc: String,
    expanded: State<Boolean>,
    selectedItem: State<String>,
    onClick: () -> Unit,
    onDismissRequest: () -> Unit,
    onChangeItem: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        DDMField(
            title = title,
            desc = desc,
            expanded = expanded,
            selectedItem = selectedItem,
            onClick = onClick
        )
//        Spacer(modifier = Modifier.height(10.dp))
        Row(Modifier.padding(top = 10.dp).align(Alignment.End)) {
            DDMBranch(
                expanded = expanded,
                onDismissRequest = onDismissRequest,
                onChangeItem = onChangeItem,
                selectedItem = selectedItem,
            )
        }
    }
}

@Composable
private fun DDMField(
    title: String,
    desc: String,
    selectedItem: State<String>,
    onClick: () -> Unit,
    expanded: State<Boolean>
) {
    val shape = RoundedCornerShape(12.dp)
    val selectedColor =
        if (expanded.value) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.primary
    val angle = if (expanded.value) 180f else 0f
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
        Text(text = "${selectedItem.value} $desc", color = selectedColor)
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.rotate(animatedAngle),
            tint = selectedColor
        )
    }
}

@Composable
fun DDMBranch(
    expanded: State<Boolean>,
    onDismissRequest: () -> Unit,
    onChangeItem: (String) -> Unit,
    selectedItem: State<String>,
) {
    val courseList = listOf("1", "2", "3", "4")
    DDM(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = Modifier,
        selectedItem = selectedItem,
        onChangeItem = onChangeItem,
        listItems = courseList
    )
}

// Common
@Composable
fun DDM(
    expanded: State<Boolean>,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    selectedItem: State<String>,
    onChangeItem: (String) -> Unit,
    listItems: List<String>,
) {
    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        listItems.forEach { label ->
            DDMItem(
                text = label,
                onClick = { onChangeItem(label) },
                selected = selectedItem.value == label
            )
        }
    }
}

@Composable
fun DDMItem(text: String, onClick: () -> Unit, selected: Boolean) {
    DropdownMenuItem(
        text = { Text(text = text) },
        onClick = onClick,
        modifier = if (selected) Modifier.background(Color.Black.copy(alpha = 0.3f)) else Modifier
    )
}


