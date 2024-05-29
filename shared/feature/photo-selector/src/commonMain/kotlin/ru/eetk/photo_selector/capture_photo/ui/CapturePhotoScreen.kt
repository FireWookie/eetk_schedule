package ru.eetk.photo_selector.capture_photo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.eetk.components.platform.PlatformCamera
import ru.eetk.photo_selector.capture_photo.component.CapturePhotoComponent

@Composable
fun CapturePhotoScreen(component: CapturePhotoComponent) {
    PlatformCamera(
        modifier = Modifier
            .fillMaxSize(),
        photo = component::onCaptureResult
    )
}