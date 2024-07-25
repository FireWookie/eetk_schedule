package ru.eetk.settings.about_app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.icons.EETKIcon
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.components.layout.EETKColumn
import ru.eetk.resources.EetkRes
import ru.eetk.settings.about_app.component.AboutAppComponent


/**
 * AboutAppScreen - экран "о приложении", находиться в настройках
 * @param component - принимает на вход AboutAppComponent
 */
@Composable
internal fun AboutAppScreen(component: AboutAppComponent) {
    Scaffold(
        topBar = {
            CenteredTopAppBar(
                text = stringResource(EetkRes.strings.about_app),
                onBackClicked = component::onBackClicked
            )
        },
        content = { insetPadding ->
            AboutAppScreenComponent(
                component = component,
                insetPadding = insetPadding.calculateTopPadding(),
            )
        }
    )
}

@Composable
private fun AboutAppScreenComponent(
    component: AboutAppComponent,
    insetPadding: Dp,
) {
    EETKColumn(
        topAppBarPadding = insetPadding,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        EETKIcon(
            painterResource(EetkRes.images.logo)
        )
        AboutAppSupportContent(
            onClickTG = component::onTGClicked
        )
        Text(
            text =  stringResource(EetkRes.strings.app_version),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
private fun AboutAppSupportContent(
    onClickTG: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(EetkRes.strings.about_app_support_dev),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(EetkRes.strings.about_app_support_tinkoff),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 20.dp)
        )
        Text(
            text = stringResource(EetkRes.strings.about_app_support_sberbank),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 20.dp)
        )
        HorizontalDivider(modifier = Modifier.padding(20.dp))
        Text(
            text = stringResource(EetkRes.strings.about_app_support),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(EetkRes.strings.about_app_support_telegram),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable(onClick = onClickTG).padding()
        )
    }
}