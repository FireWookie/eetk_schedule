package ru.eetk.photo_selector.root.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.eetk.compose_sheets.utils.BottomSheetContentState
import ru.eetk.photo_selector.root.component.store.PhotoSelectorDialogState
import ru.eetk.theme.util.BaseComponent


fun buildPhotoSelectorComponent(
    componentContext: ComponentContext
): PhotoSelectorComponent = PhotoSelectorComponentImpl(
    componentContext = componentContext
)


internal class PhotoSelectorComponentImpl(
    componentContext: ComponentContext,
): BaseComponent(componentContext = componentContext), PhotoSelectorComponent {
    private val _state = MutableStateFlow(PhotoSelectorDialogState)
    override val state: StateFlow<PhotoSelectorDialogState> = _state

    override val bottomSheetContentState: StateFlow<BottomSheetContentState> = state
}