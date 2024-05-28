package ru.eetk.photo_selector.root.component.store

import ru.eetk.compose_sheets.utils.BottomSheetContentState

data object PhotoSelectorDialogState: BottomSheetContentState {
    override val isDismissAllowed: Boolean = true
}
