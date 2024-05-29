package ru.eetk.settings.profile.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.eetk.compose_sheets.utils.BottomSheetContentComponent
import ru.eetk.libraries.flow.FlowConstants
import ru.eetk.libraries.flow.models.CaptureData
import ru.eetk.photo_selector.menu.component.buildPhotoMenuComponent
import ru.eetk.settings.profile.component.config.RootBottomSheetConfig
import ru.eetk.theme.util.BaseComponent

internal fun buildProfileComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit,
): ProfileComponent = ProfileComponentImpl(
    componentContext = componentContext,
    backClick = backClick,
)

internal class ProfileComponentImpl(
    componentContext: ComponentContext,
    private val backClick: () -> Unit,
): ProfileComponent, BaseComponent(componentContext = componentContext), KoinComponent {

    private val captureFlow: MutableSharedFlow<CaptureData> by inject(named(FlowConstants.ROOT_FLOW_EVENT))

    init {
        collectFlowData()
    }

    override fun onOpenCamera() {
        onDismiss()
    }

    override fun onDismiss() {
        bottomSheetSlotNavigation.dismiss()
    }

    override fun onClickChangePhoto() {
        bottomSheetSlotNavigation.activate(RootBottomSheetConfig.PhotoSelectorScreen)
    }

    override fun onClickChangePassword() {

    }

    private fun collectFlowData() {
        ioScope.launch {
            captureFlow
                .distinctUntilChanged()
                .collectLatest {
                    when(it) {
                        is CaptureData.PhotoResult -> println("Result collected here")
                    }
                }
        }
    }

    private val bottomSheetSlotNavigation = SlotNavigation<RootBottomSheetConfig>()

    override val bottomSheetSlot: Value<ChildSlot<*, BottomSheetContentComponent>> =
        childSlot(
            source = bottomSheetSlotNavigation,
            handleBackButton = false,
            serializer = RootBottomSheetConfig.serializer(),
            childFactory = ::createBottomSheet
        )


    private fun createBottomSheet(
        config: RootBottomSheetConfig,
        componentContext: ComponentContext
    ): BottomSheetContentComponent {
        return when (config) {
            RootBottomSheetConfig.PhotoSelectorScreen -> {
                buildPhotoMenuComponent(
                    componentContext = componentContext,
                    closeMenu = ::onDismiss
                )
            }
        }
    }

    override fun onBackClicked() = backClick()
}