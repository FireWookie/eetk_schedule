package ru.eetk.photo_selector.menu.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.binder.BinderLifecycleMode
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.eetk.compose_sheets.utils.BottomSheetContentState
import ru.eetk.libraries.flow.FlowConstants.ROOT_FLOW
import ru.eetk.libraries.flow.FlowConstants.ROOT_FLOW_EVENT
import ru.eetk.libraries.flow.models.CaptureData
import ru.eetk.libraries.flow.models.EffectRoot
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorDialogState
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStore
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStore.*
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStoreFactory
import ru.eetk.theme.util.BaseComponent


fun buildPhotoMenuComponent(
    componentContext: ComponentContext,
    closeMenu: () -> Unit
): PhotoMenuComponent = PhotoMenuComponentImpl(
    componentContext = componentContext,
    onCloseMenu = closeMenu
)


internal class PhotoMenuComponentImpl(
    componentContext: ComponentContext,
    private val onCloseMenu: () -> Unit
): BaseComponent(componentContext = componentContext), PhotoMenuComponent {
    private val _state = MutableStateFlow(PhotoSelectorDialogState)
    override val state: StateFlow<PhotoSelectorDialogState> = _state

    private val rootFlowEvent: MutableSharedFlow<EffectRoot> by inject(named(ROOT_FLOW))
    private val captureFlow: MutableSharedFlow<CaptureData> by inject(named(ROOT_FLOW_EVENT))

    private val storeFactory: StoreFactory by inject()

    private val selectorStore: PhotoSelectorStore = instanceKeeper.getStore {
        PhotoSelectorStoreFactory(
            storeFactory = storeFactory
        ).create()
    }

    override val sideEffect: MutableSharedFlow<SideEffect> = MutableSharedFlow(extraBufferCapacity = 1)

    @OptIn(ExperimentalCoroutinesApi::class)
    override val stateFlow: StateFlow<State> = selectorStore.stateFlow
    override fun clickSelectGallery() {
        sideEffect.tryEmit(SideEffect.LaunchPhoto)
    }

    override fun closeMenu() {
        onCloseMenu()
    }

    override fun clickPhoto() {
        onCloseMenu()
        rootFlowEvent.tryEmit(EffectRoot.OpenCameraScreen)
    }

    init {
        bind(lifecycle, BinderLifecycleMode.CREATE_DESTROY) {
            selectorStore.labels bindTo ::bindLabels
        }
    }

    override fun onFileSelected(photos: List<ByteArray>) {
        captureFlow.tryEmit(CaptureData.PhotoResult(photos.first()))
        onCloseMenu()
    }

    private fun bindLabels(label: Label) {
        when(label){
            Label.NavigateToCamera -> rootFlowEvent.tryEmit(EffectRoot.OpenCameraScreen)
            Label.PickFile -> sideEffect.tryEmit(SideEffect.LaunchPhoto)
        }
    }

    override val bottomSheetContentState: StateFlow<BottomSheetContentState> = state
}