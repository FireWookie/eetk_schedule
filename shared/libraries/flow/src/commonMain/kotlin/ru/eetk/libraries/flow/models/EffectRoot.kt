package ru.eetk.libraries.flow.models

sealed interface EffectRoot {
    data object OpenCameraScreen: EffectRoot
}