package ru.eetk.photo_selector.root.component

import kotlinx.coroutines.flow.StateFlow
import ru.eetk.compose_sheets.utils.BottomSheetContentComponent
import ru.eetk.photo_selector.root.component.store.PhotoSelectorDialogState

interface PhotoSelectorComponent: BottomSheetContentComponent {
    val state: StateFlow<PhotoSelectorDialogState>
}