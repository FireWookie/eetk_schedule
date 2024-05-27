package ru.eetk.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

//
//package com.example.ui.theme
//
//import androidx.compose.material3.Typography
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.sp
//
//import androidx.compose.ui.text.googlefonts.GoogleFont
//import androidx.compose.ui.text.googlefonts.Font
//
//val provider = GoogleFont.Provider(
//    providerAuthority = "com.google.android.gms.fonts",
//    providerPackage = "com.google.android.gms",
//    certificates = R.array.com_google_android_gms_fonts_certs
//)
//
//val bodyFontFamily = FontFamily(
//    Font(
//        googleFont = GoogleFont("Roboto"),
//        fontProvider = provider,
//    )
//)
//
//val displayFontFamily = FontFamily(
//    Font(
//        googleFont = GoogleFont("Roboto"),
//        fontProvider = provider,
//    )
//)
//
//// Default Material 3 typography values

@Composable
internal fun EETKTypography(colorScheme: ColorScheme): Typography {
    val baseline = Typography()
    val typography = Typography(
//    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
//    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
//    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
        headlineLarge = baseline.headlineLarge.copy(color = colorScheme.primary),
//    headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
//    headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
//    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
//    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
//    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
//    bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
//    bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
//    bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
//    labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
//    labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
//    labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
    )
    return typography
}
