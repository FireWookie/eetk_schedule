package ru.eetk.theme.util

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.KoinComponent

abstract class BaseComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, KoinComponent {
    val mainScope = CoroutineScope(Dispatchers.Main.immediate)
    val ioScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
}