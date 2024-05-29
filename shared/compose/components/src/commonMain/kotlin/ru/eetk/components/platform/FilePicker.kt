package ru.eetk.components.platform

import androidx.compose.runtime.Composable


interface MPFile<out T : Any> {
    // on JS this will be a file name, on other platforms it will be a file path
    val path: String
    val platformFile: T
}

typealias FileSelected = (MPFile<Any>?) -> Unit

@Composable
expect fun FilePicker(
    show: Boolean,
    initialDirectory: String? = null,
    fileExtensions: List<String> = emptyList(),
    onFileSelected: FileSelected
)