package ru.eetk.photo_selector.capture_photo.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackCallback
import ru.eetk.theme.util.BaseComponent

fun buildCapturePhotoComponent(
    componentContext: ComponentContext,
    onResult: (ByteArray) -> Unit,
    onCloseCamera: () -> Unit
): CapturePhotoComponent = CapturePhotoComponentImpl(
    componentContext = componentContext,
    onResult = onResult,
    closeCamera = onCloseCamera
)

internal class CapturePhotoComponentImpl(
    componentContext: ComponentContext,
    private val onResult: (ByteArray) -> Unit,
    private val closeCamera: () -> Unit
): BaseComponent(componentContext), CapturePhotoComponent {

    private val backCallback = BackCallback { closeCamera() }

    init {
        backHandler.register(backCallback)
    }

    override fun onCaptureResult(byteArray: ByteArray) = onResult(byteArray)
    override fun onCloseCamera() = closeCamera()
}