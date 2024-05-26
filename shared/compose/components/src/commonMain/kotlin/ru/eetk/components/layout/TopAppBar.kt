package ru.eetk.components.layout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleAppBar(
    text: String,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.TopAppBar(
        title = { Text(text = text) },
        modifier = modifier
    )
}