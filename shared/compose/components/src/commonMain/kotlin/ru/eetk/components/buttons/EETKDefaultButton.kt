package ru.eetk.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun EETKDefaultButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        onClick = onClick,
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    )
}