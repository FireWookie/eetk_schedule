package ru.eetk.schedule.changes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.eetk.components.dialogs.EETKDatePickerDialog
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.text.ClickableText
import ru.eetk.schedule.changes.component.ChangesComponent

@Composable
internal fun ChangesScreen(component: ChangesComponent) {
    EETKColumn(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var asda by remember { mutableStateOf(false) }

        ClickableText(
            text = "Сегодня",
            style = MaterialTheme.typography.titleLarge,
            onClick = {asda = true}
        )
        Box(Modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color.LightGray)
            .clickable {}
        )
        EETKDatePickerDialog(
            isOpened = asda,
            onConfirm = { },
            onDismissRequest = {asda = false},
        )
    }
}