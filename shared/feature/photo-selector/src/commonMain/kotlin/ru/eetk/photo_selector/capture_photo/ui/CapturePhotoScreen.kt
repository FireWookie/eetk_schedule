package ru.eetk.photo_selector.capture_photo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.arkivanov.essenty.backhandler.BackCallback
import com.arkivanov.essenty.backhandler.BackHandler
import ru.eetk.components.platform.PlatformCamera
import ru.eetk.photo_selector.capture_photo.component.CapturePhotoComponent

@Composable
fun CapturePhotoScreen(component: CapturePhotoComponent) {
    BackHandler(component.backHandler, onBack = component::onCloseCamera)
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        PlatformCamera(
            modifier = Modifier
                .fillMaxSize(),
            photo = component::onCaptureResult,
            onBack = component::onCloseCamera
        )
    }
}


@Composable
fun BackHandler(backHandler: BackHandler, isEnabled: Boolean = true, onBack: () -> Unit) {
    val currentOnBack by rememberUpdatedState(onBack)

    val callback =
        remember {
            BackCallback(isEnabled = isEnabled) {
                currentOnBack()
            }
        }

    SideEffect { callback.isEnabled = isEnabled }

    DisposableEffect(backHandler) {
        backHandler.register(callback)
        onDispose { backHandler.unregister(callback) }
    }
}
