package ru.eetk.mobileapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun App() {
    
    Text("Ios Work")
}

internal expect fun openUrl(url: String?)