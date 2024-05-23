package ru.eetk.components.layout

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun EETKContainer(
    content: @Composable ColumnScope.() -> Unit
) {
    val localFocusManager = LocalFocusManager.current

    CenteredColumn(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        localFocusManager.clearFocus()
                    }
                )
            }
    ) {
        content()
    }
}