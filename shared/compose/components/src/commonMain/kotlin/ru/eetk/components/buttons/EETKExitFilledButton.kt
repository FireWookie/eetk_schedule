package ru.eetk.components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EETKExitFilledButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.error,
        contentColor = MaterialTheme.colorScheme.onError
    )
    EETKPrimaryFilledButton(
        text = text,
        modifier = Modifier.height(40.dp).then(modifier),
        onClick = onClick,
        colors = colors
    )
}