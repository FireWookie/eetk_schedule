package ru.eetk.settings.profile.component

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

internal fun buildProfileComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit,
): ProfileComponent = ProfileComponentImpl(
    componentContext = componentContext,
    backClick = backClick
)

internal class ProfileComponentImpl(
    componentContext: ComponentContext,
    private val backClick: () -> Unit
): ProfileComponent, ComponentContext by componentContext, KoinComponent {
    override fun onBackClicked() = backClick()
}