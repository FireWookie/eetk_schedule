package ru.eetk.splash.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.splash.component.SplashComponent

@Composable
fun SplashScreen(component: SplashComponent) {
    CenteredColumn(
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()

    }
}