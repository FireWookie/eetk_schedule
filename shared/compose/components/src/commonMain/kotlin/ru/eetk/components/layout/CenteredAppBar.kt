package ru.eetk.components.layout

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.eetk.components.buttons.PrimaryBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenteredTopAppBar(
    text: String,
    onBackClicked: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = text) },
        navigationIcon = { PrimaryBackButton(onClick = onBackClicked, showBackground = false) }
    )
}