package ru.eetk.settings.design.component

import androidx.compose.runtime.State

interface DesignComponent {
    fun onBackClicked()

    fun onDynamicColorChange()

    fun onSystemThemeClicked()

    fun onOffDarkThemeClicked()

    fun onOnDarkThemeClicked()

}