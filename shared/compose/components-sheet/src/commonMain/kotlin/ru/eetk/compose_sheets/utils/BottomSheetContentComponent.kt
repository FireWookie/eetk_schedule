package ru.eetk.compose_sheets.utils

import kotlinx.coroutines.flow.StateFlow

interface BottomSheetContentComponent {

    val bottomSheetContentState: StateFlow<BottomSheetContentState>
}