package ru.eetk.components.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Работа с камерой
 * @param modifier modifier
 * @param photo функция, которая отдает link получившийся фотки
 */
@Composable
expect fun PlatformCamera(
    modifier: Modifier,
    photo: (String) -> Unit
)