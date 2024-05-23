package ru.eetk.settings.profile.component

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

internal fun buildProfileComponent(
    componentContext: ComponentContext
): ProfileComponent = ProfileComponentImpl(
    componentContext = componentContext
)

internal class ProfileComponentImpl(
    componentContext: ComponentContext
): ProfileComponent, ComponentContext by componentContext, KoinComponent {

}