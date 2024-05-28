package ru.eetk.settings.profile.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackCallback
import org.koin.core.component.KoinComponent
import ru.eetk.compose_sheets.utils.BottomSheetContentComponent
import ru.eetk.photo_selector.root.component.buildPhotoSelectorComponent
import ru.eetk.settings.profile.component.config.RootBottomSheetConfig

internal fun buildProfileComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit,
): ProfileComponent = ProfileComponentImpl(
    componentContext = componentContext,
    backClick = backClick
)

internal class ProfileComponentImpl(
    componentContext: ComponentContext,
    private val backClick: () -> Unit,
): ProfileComponent, ComponentContext by componentContext, KoinComponent {

    private val backCallback = BackCallback {
        val child = bottomSheetSlot.value.child
        if (child != null && child.instance.bottomSheetContentState.value.isDismissAllowed) {
            bottomSheetSlotNavigation.dismiss()
        }
    }

    override fun onDismiss() {
        bottomSheetSlotNavigation.dismiss()
    }

    override fun onClickChangePassword() {
        bottomSheetSlotNavigation.activate(RootBottomSheetConfig.PhotoSelectorScreen)
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
                buildPhotoSelectorComponent(componentContext = componentContext)
            }
        }
    }

    override fun onBackClicked() = backClick()
}