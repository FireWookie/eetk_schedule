package ru.eetk.photo_selector.capture_photo.component

import com.arkivanov.essenty.backhandler.BackHandlerOwner

interface CapturePhotoComponent: BackHandlerOwner {

    fun onCaptureResult(byteArray: ByteArray)

    fun onCloseCamera()
}