package ru.eetk.components.buttons

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable

@Composable
fun FilledButton(
    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    shape: Shape = ButtonDefaults.shape,
//    colors: ButtonColors = ButtonDefaults.buttonColors(),
//    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
//    border: BorderStroke? = null,
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable() (RowScope.() -> Unit)
) {
    Button(
        onClick = onClick,
        content = content
    )
}