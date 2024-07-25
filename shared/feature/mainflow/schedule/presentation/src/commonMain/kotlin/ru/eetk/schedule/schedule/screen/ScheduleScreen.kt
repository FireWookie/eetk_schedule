package ru.eetk.schedule.schedule.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.text.ClickableText
import ru.eetk.schedule.schedule.component.ScheduleComponent

@Composable
internal fun ScheduleScreen(component: ScheduleComponent) {
    EETKColumn(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ClickableText(
            text = "c 20.05.2024 по 25.05.2024",
            style = MaterialTheme.typography.titleLarge,
            onClick = {}
        )
        Box(Modifier.fillMaxWidth().height(350.dp).clip(MaterialTheme.shapes.medium).background(Color.LightGray))
    }
}