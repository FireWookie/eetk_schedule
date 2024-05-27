package ru.eetk.theme.util

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.component.KoinComponent
import ru.eetk.coroutines.coroutineScope

abstract class BaseComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, KoinComponent {
    val mainScope = coroutineScope()
    val ioScope = coroutineScope(Dispatchers.IO)
}