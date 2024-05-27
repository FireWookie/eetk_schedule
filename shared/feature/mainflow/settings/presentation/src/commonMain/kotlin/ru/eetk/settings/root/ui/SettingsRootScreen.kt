package ru.eetk.settings.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.eetk.animation.backAnimation
import ru.eetk.settings.design.ui.DesignScreen
import ru.eetk.settings.menu.ui.SettingsMenuScreen
import ru.eetk.settings.notification.ui.NotificationScreen
import ru.eetk.settings.profile.ui.ProfileScreen
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