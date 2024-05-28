package ru.eetk.settings.profile.component

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.value.Value
import ru.eetk.compose_sheets.utils.BottomSheetContentComponent

interface ProfileComponent {
    fun onBackClicked()

    val bottomSheetSlot: Value<ChildSlot<*, BottomSheetContentComponent>>

    fun onDismiss()

    fun onClickChangePassword()
}