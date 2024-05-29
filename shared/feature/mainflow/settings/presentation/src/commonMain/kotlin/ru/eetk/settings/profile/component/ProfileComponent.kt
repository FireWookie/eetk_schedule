package ru.eetk.settings.profile.component

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.eetk.compose_sheets.utils.BottomSheetContentComponent
import ru.eetk.photo_selector.capture_photo.component.CapturePhotoComponent
import ru.eetk.settings.about_app.component.AboutAppComponent
import ru.eetk.settings.design.component.DesignComponent
import ru.eetk.settings.menu.component.SettingsMenuComponent
import ru.eetk.settings.notification.component.NotificationComponent

interface ProfileComponent {
    fun onBackClicked()

    val bottomSheetSlot: Value<ChildSlot<*, BottomSheetContentComponent>>

    fun onDismiss()

    fun onClickChangePassword()

    fun onOpenCamera()

    fun onClickChangePhoto()

}