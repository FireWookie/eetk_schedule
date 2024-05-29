package ru.eetk.photo_selector.menu.component.store

import com.arkivanov.mvikotlin.core.store.Store

interface PhotoSelectorStore: Store<PhotoSelectorStore.Intent, PhotoSelectorStore.State, PhotoSelectorStore.Label> {

    sealed interface Intent {
        data object SelectPhotoByGallery: Intent

        data object CapturePhotoByCamera: Intent
    }

    sealed interface Message {
        data object FilePickerState: Message
    }

    data class State(
        val openFilePicker: Boolean = false
    )

    sealed interface Label {
        data object NavigateToCamera: Label
        data object PickFile: Label
    }

    sealed interface SideEffect {
        data object LaunchPhoto: SideEffect
    }
}