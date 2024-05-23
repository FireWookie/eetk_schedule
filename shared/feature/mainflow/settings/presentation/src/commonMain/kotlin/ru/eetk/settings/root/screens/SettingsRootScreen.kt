package ru.eetk.settings.root.screens

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.eetk.animation.backAnimation
import ru.eetk.settings.design.screens.DesignScreen
import ru.eetk.settings.menu.screen.SettingsMenuScreen
import ru.eetk.settings.notification.screens.NotificationScreen
import ru.eetk.settings.profile.screens.ProfileScreen
import ru.eetk.settings.root.component.SettingsRootComponent

@Composable
fun SettingsRootScreen(
    component: SettingsRootComponent
) {
    Children(
        stack = component.childStack,
        animation = backAnimation(
            backHandler = component.backHandler,
            onBack = component::onBackClicked
        )
    ) {
        when(val child = it.instance) {
            is SettingsRootComponent.Child.Design -> DesignScreen(child.component)
            is SettingsRootComponent.Child.Menu -> SettingsMenuScreen(child.component)
            is SettingsRootComponent.Child.Notification -> NotificationScreen(child.component)
            is SettingsRootComponent.Child.Profile -> ProfileScreen(child.component)
        }
    }
}