package ru.eetk.review.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.buttons.EETKPrimaryFilledButton
import ru.eetk.components.layout.EETKColumn
import ru.eetk.resources.EetkRes
import ru.eetk.review.auth.component.ReviewAuthComponent

@Composable
fun ReviewAuthScreen(component: ReviewAuthComponent) {
    EETKColumn {
        Text(
            text = stringResource(EetkRes.strings.auth_need),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        EETKPrimaryFilledButton(
            text = stringResource(EetkRes.strings.auth),
            onClick = component::onAuthClicked,
            modifier = Modifier.height(60.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}