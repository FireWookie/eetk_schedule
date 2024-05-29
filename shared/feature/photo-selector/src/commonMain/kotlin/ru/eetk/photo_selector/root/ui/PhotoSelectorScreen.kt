package ru.eetk.photo_selector.root.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.eetk.components.layout.EETKColumn
import ru.eetk.photo_selector.root.component.PhotoSelectorComponent

@Composable
fun PhotoSelectorScreen(component: PhotoSelectorComponent) {
    Column(
        modifier = Modifier.navigationBarsPadding()
    ) {
        Text("Hello World")
    }
}