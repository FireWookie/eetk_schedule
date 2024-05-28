package ru.eetk.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun EETKPrimaryFilledButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    //    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
//    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
//    border: BorderStroke? = null,
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
//    content: @Composable() (RowScope.() -> Unit)
) {
    Button(
        onClick = onClick,
        colors = colors,
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
//            .padding(horizontal = 16.dp)
            .then(modifier),
        content = { Text(text = text) }
    )
}