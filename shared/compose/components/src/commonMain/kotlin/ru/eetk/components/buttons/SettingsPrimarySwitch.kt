package ru.eetk.components.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SettingsPrimaryDropDownMenu(
    text: String,
    selectedItem:String,
    dropDownMenuItems: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    var clicked by remember {
        mutableStateOf(false)
    }
    var angle by remember {
        mutableStateOf(0f)
    }
    val angl by animateFloatAsState(angle)
        if (!clicked) angle = 0f
    Column(modifier = Modifier.wrapContentSize(Alignment.TopEnd)) {
        Row(
            modifier = modifier.fillMaxWidth().height(50.dp).clip(RoundedCornerShape(12.dp))
                .clickable(onClick = {
                    clicked = !clicked
                    angle = if (angle == 0f) 180f else 0f
                }).padding(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = selectedItem,
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.rotate(angl)
            )

        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(Modifier.align(Alignment.End)) {
            DropdownMenu(
                expanded = clicked,
                modifier = Modifier,
                onDismissRequest = { clicked = false },
                content = dropDownMenuItems
            )
        }
    }
}
//DropdownMenuItem(text = { Text("Выключена") }, onClick = {})
//DropdownMenuItem(text = { Text("Включена") }, onClick = {})
@Composable
fun DropDownMenuitem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenuItem(
        text = { Text(text = text) },
        onClick = onClick

    )
}