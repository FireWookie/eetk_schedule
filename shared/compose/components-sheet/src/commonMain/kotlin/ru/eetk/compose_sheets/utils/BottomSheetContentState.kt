package ru.eetk.compose_sheets.utils

interface BottomSheetContentState {

    /**
     * Разрешено ли сворачивание этого Bottom Sheet.
     */
    val isDismissAllowed: Boolean
}