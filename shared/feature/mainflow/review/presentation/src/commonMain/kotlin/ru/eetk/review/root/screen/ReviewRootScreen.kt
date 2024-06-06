package ru.eetk.review.root.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import dev.icerock.moko.resources.compose.stringResource
import io.github.alexzhirkevich.cupertino.decompose.NativeChildren
import ru.eetk.animation.stackAnim
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.layout.TitleAppBar
import ru.eetk.resources.EetkRes
import ru.eetk.review.auth.component.ReviewAuthComponent
import ru.eetk.review.auth.ui.ReviewAuthScreen
import ru.eetk.review.root.component.ReviewRootComponent

@Composable
fun ReviewRootScreen(component: ReviewRootComponent) {
    Scaffold(
        topBar = { TitleAppBar(text = stringResource(EetkRes.strings.eetk_review)) },
        content = { insetPadding ->
            ReviewRootScreenContent(
                component = component,
                insetPadding = insetPadding.calculateTopPadding()
            )
        }
    )
}

@Composable
fun ReviewRootScreenContent(
    component: ReviewRootComponent,
    insetPadding: Dp,
) {
    val authed = false
    EETKColumn(
        topAppBarPadding = insetPadding
    ) {
        NativeChildren(
            stack = component.childStack,
            onBack = component::onBackClicked,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnim()
        ) { config ->
            when (val child = config.instance) {
                is ReviewRootComponent.Child.Auth -> ReviewAuthScreen(component = child.component)
            }

        }
    }
}