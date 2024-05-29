package ru.eetk.photo_selector.menu.component

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import ru.eetk.compose_sheets.utils.BottomSheetContentComponent
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorDialogState
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStore

interface PhotoMenuComponent: BottomSheetContentComponent {
    val state: StateFlow<PhotoSelectorDialogState>
    val stateFlow: StateFlow<PhotoSelectorStore.State>

    val sideEffect: MutableSharedFlow<PhotoSelectorStore.SideEffect>

    fun clickSelectGallery()

    fun closeMenu()

    fun clickPhoto()

    fun onFileSelected(photos: List<ByteArray>)
}