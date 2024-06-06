package ru.eetk.components.dialogs

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EETKDatePickerDialog(
    isOpened: Boolean,
    onConfirm: () -> Unit,
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit  = { DatePickerButton(text = "ОК", onClick = onConfirm) },
    dismissButton: @Composable() (() -> Unit)? = { DatePickerButton(text = "Отмена", onClick = onDismissRequest) },
) {
    if (isOpened)
        DatePickerDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = confirmButton,
            dismissButton = dismissButton
        ) {
            val state = rememberDatePickerState()
            DatePicker(
                state = state,
            )
        }
}

@Composable
private fun DatePickerButton(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
    ) {
        Text(text = text)
    }
}