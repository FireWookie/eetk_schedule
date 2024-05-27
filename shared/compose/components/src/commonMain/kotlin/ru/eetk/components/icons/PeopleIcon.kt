package ru.eetk.components.icons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val Height = 120.dp
private val Width = 140.dp

@Composable
fun PeopleIcon() {
    Icon(
        imageVector = Icons.Filled.Person,
        contentDescription = null,
        modifier = Modifier
            .height(Height)
            .width(Width)
    )
}