package ru.eetk.settings.profile.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import ru.eetk.components.buttons.EETKExitFilledButton
import ru.eetk.components.cards.EETKSettingCard
import ru.eetk.components.dialogs.EETKDialog
import ru.eetk.components.icons.DefaultPhoto
import ru.eetk.components.layout.CenteredTopAppBar
import ru.eetk.components.layout.EETKColumn
import ru.eetk.components.layout.EETKMenuDropDown
import ru.eetk.components.layout.EETKMenuText
import ru.eetk.compose_sheets.slot.ChildSlotModalBottomSheet
import ru.eetk.photo_selector.menu.component.PhotoMenuComponent
import ru.eetk.photo_selector.menu.component.ui.PhotoMenuScreen
import ru.eetk.resources.EetkRes
import ru.eetk.settings.profile.component.ProfileComponent

@Composable
internal fun ProfileScreen(component: ProfileComponent) {
    Scaffold(
        topBar = {
            CenteredTopAppBar(
                text = stringResource(EetkRes.strings.settings_profile),
                onBackClicked = component::onBackClicked
            )
        },
        content = { insetPadding ->
            ProfileScreenContent(
                component = component,
                insetPadding = insetPadding.calculateTopPadding()
            )
        }
    )
}

@Composable
internal fun ProfileScreenContent(
    component: ProfileComponent,
    insetPadding: Dp,
) {
    var showDialogUserName by remember { mutableStateOf(false) }
    var showDialogEmail by remember { mutableStateOf(false) }
    var showDDM1 by remember { mutableStateOf(false) }
    var showDDM2 by remember { mutableStateOf(false) }

    ChildSlotModalBottomSheet(
        sheetContentSlotState = component.bottomSheetSlot,
        onDismiss = component::onDismiss,
        content = { component ->
            PhotoMenuScreen(component = component as PhotoMenuComponent)
        }
    )

    EETKColumn(
        insetPadding = insetPadding,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        ChangePhoto(
            photo = painterResource(EetkRes.images.profile_template),
            onClick = component::onClickChangePhoto
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            EETKMenuText(
                leadingText = stringResource(EetkRes.strings.username),
                trailingText = "Some Username",
                onClick = { showDialogUserName = !showDialogUserName }
            )
            EETKMenuText(
                leadingText = stringResource(EetkRes.strings.mail),
                trailingText = "someemail@mail.ru",
                onClick = { showDialogEmail = !showDialogEmail }
            )
            EETKMenuDropDown(
                title = stringResource(EetkRes.strings.branch),
                selectedItem = "state.themeItems",
                expanded = showDDM1,
                onClick =  { showDDM1 = false },
                listItems = emptyList(),
                onChangeItem = {  },
                itemConvertText = { "МТО" }
            )
            EETKMenuDropDown(
                title = stringResource(EetkRes.strings.course),
                selectedItem = "state.themeItems",
                expanded = showDDM2,
                onClick = { showDDM2 = false },
                listItems = emptyList(),
                onChangeItem = {},
                itemConvertText = { "3 Курс" }
            )
        }
        EETKSettingCard(
            text = stringResource(EetkRes.strings.change_password),
            onClick = {}
        )


        EETKExitFilledButton(
            text = stringResource(EetkRes.strings.exit),
            onClick = {}
        )
        if (showDialogUserName) {
            EETKDialog(
                title = stringResource(EetkRes.strings.username),
                desc = stringResource(EetkRes.strings.alert_change_username),
                buttonText = stringResource(EetkRes.strings.apply),
                tfPlaceHolder = "Some Username",
                canGoBack = true,
                tfValue = "",
                tfOnValueChange = {},
                onButtonClick = {},
                onDismissRequest = { showDialogUserName = false }
            )
        }
        if (showDialogEmail) {
            EETKDialog(
                title = stringResource(EetkRes.strings.mail),
                desc = stringResource(EetkRes.strings.alert_change_mail),
                buttonText = stringResource(EetkRes.strings.next),
                tfPlaceHolder = "someemail@mail.ru",
                canGoBack = true,
                tfValue = "",
                tfOnValueChange = {},
                onButtonClick = {},
                onDismissRequest = { showDialogEmail = false }
            )
        }
    }
}

@Composable
internal fun ChangePhoto(
    photo: Painter,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier.clip(RoundedCornerShape(12.dp)).clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultPhoto(painter = photo)
        Text(
            text = stringResource(EetkRes.strings.change_photo),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(5.dp)
        )
    }
}