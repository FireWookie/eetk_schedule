package ru.eetk.settings.root.component

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import ru.eetk.settings.about_app.component.AboutAppComponent
import ru.eetk.settings.design.component.DesignComponent
import ru.eetk.settings.menu.component.SettingsMenuComponent
import ru.eetk.settings.notification.component.NotificationComponent
import ru.eetk.settings.profile.component.ProfileComponent


@Stable
interface SettingsRootComponent: BackHandlerOwner {

    val childStack: Value<ChildStack<*, Child>>

    fun onBackClicked()

    sealed class Child {
        class Menu(val component: SettingsMenuComponent): Child()

        class Profile(val component: ProfileComponent): Child()

        class Notification(val component: NotificationComponent): Child()

        class Design(val component: DesignComponent): Child()

        class AboutApp(val component: AboutAppComponent): Child()
    }
}