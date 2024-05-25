package ru.eetk.review.root.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.eetk_review
import org.jetbrains.compose.resources.stringResource
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.review.root.component.ReviewRootComponent
import ru.eetk.components.layout.TopappBar

@Composable
fun ReviewRootScreen(component: ReviewRootComponent) {
    Scaffold(
        topBar = { TopappBar(text = stringResource(Res.string.eetk_review)) },
        content = { insetPadding -> ReviewRootScreenContent(component = component, insetPadding = insetPadding) }
    )
}

@Composable
fun ReviewRootScreenContent(
    component: ReviewRootComponent,
    insetPadding: PaddingValues
) {
    CenteredColumn(
        modifier = Modifier.padding(insetPadding),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Отзывы")
    }
}