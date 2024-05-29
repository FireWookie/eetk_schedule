package ru.eetk.libraries.flow.models

sealed interface CaptureData {
    data class PhotoResult(val byteArray: ByteArray): CaptureData
}