package ru.eetk.schedule.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.schedule
import org.jetbrains.compose.resources.stringResource
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.components.layout.TopappBar
import ru.eetk.schedule.component.ScheduleComponent

@Composable
fun ScheduleScreen(component: ScheduleComponent) {
    Scaffold(
        topBar = { TopappBar(text = stringResource(Res.string.schedule)) },
        content = { insetPadding -> ScheduleScreenContent(component = component, insetPadding = insetPadding) }
    )
}

@Composable
fun ScheduleScreenContent(
    component: ScheduleComponent,
    insetPadding: PaddingValues
) {
    CenteredColumn(
        modifier = Modifier.padding(insetPadding),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Расписание")
    }
}