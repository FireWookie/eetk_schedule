package ru.eetk.photo_selector.menu.component.ui

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.eetk.components.buttons.EETKDefaultButton
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.components.platform.photo_picker.SelectionMode
import ru.eetk.components.platform.photo_picker.rememberImagePickerLauncher
import ru.eetk.photo_selector.menu.component.PhotoMenuComponent
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStore.*
import ru.eetk.resources.EetkRes

@Composable
fun PhotoMenuScreen(component: PhotoMenuComponent) {
    val scope = rememberCoroutineScope()

    val photoPicker = rememberImagePickerLauncher(
        selectionMode = SelectionMode.Single,
        scope = scope,
        onResult = component::onFileSelected
    )

    ContentSelector(component = component)

    LaunchedEffect(Unit) {
        component.sideEffect
            .onEach {
                when(it) {
                    SideEffect.LaunchPhoto -> {
                        photoPicker.launch()
                    }
                }
            }
            .launchIn(this)
    }
}

@Composable
internal fun ContentSelector(component: PhotoMenuComponent) {
    CenteredColumn(
        isMaxSize = false,
        modifier = Modifier.navigationBarsPadding()
    ) {
        EETKDefaultButton(
            text = stringResource(EetkRes.strings.take_photo),
            onClick = component::clickPhoto
        )
        EETKDefaultButton(
            text = stringResource(EetkRes.strings.select_gallery),
            onClick = component::clickSelectGallery
        )

        EETKDefaultButton(
            text = stringResource(EetkRes.strings.cancel),
            onClick = component::closeMenu
        )
    }
}