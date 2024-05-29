package ru.eetk.photo_selector.capture_photo.component

import com.arkivanov.decompose.ComponentContext
import ru.eetk.theme.util.BaseComponent

fun buildCapturePhotoComponent(
    componentContext: ComponentContext,
    onResult: (String) -> Unit
): CapturePhotoComponent = CapturePhotoComponentImpl(
    componentContext = componentContext,
    onResult = onResult
)

internal class CapturePhotoComponentImpl(
    componentContext: ComponentContext,
    val onResult: (String) -> Unit
): BaseComponent(componentContext), CapturePhotoComponent {
    override fun onCaptureResult(url: String) = onResult(url)
}