package ru.eetk.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.setStatusBarStyle

@Composable
internal actual fun SystemAppearance(isDark: Boolean){
    LaunchedEffect(isDark) {
        UIApplication.sharedApplication.setStatusBarStyle(
            if (isDark) UIStatusBarStyleDarkContent else UIStatusBarStyleLightContent
        )
    }
}
@Composable
internal actual fun dynamicColors(isDark: Boolean, isDynamic: Boolean): ColorScheme? {
    return null
}

