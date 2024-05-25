package ru.eetk.settings.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import models.SelectedTab
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.eetk.coroutines.coroutineScope
import ru.eetk.libraries.flow.FlowConstants
import ru.eetk.settings.design.component.buildDesignComponent
import ru.eetk.settings.menu.component.buildSettingsMenuComponent
import ru.eetk.settings.notification.component.buildNotificationComponent
import ru.eetk.settings.profile.component.buildProfileComponent
import ru.eetk.theme.util.BaseComponent


fun buildSettingsRootComponent(
    componentContext: ComponentContext,
): SettingsRootComponent = SettingsRootComponentImpl(
    componentContext = componentContext
)

internal class SettingsRootComponentImpl(
    componentContext: ComponentContext,
): SettingsRootComponent, BaseComponent(componentContext), BackHandlerOwner {
    private val navigation = StackNavigation<Config>()

    private val eventFlow: MutableSharedFlow<SelectedTab> by inject(
        qualifier = named(name = FlowConstants.TAB_FLOW)
    )

    override val childStack: Value<ChildStack<*, SettingsRootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Menu,
            handleBackButton = true,
            childFactory = ::processChild,
            serializer = Config.serializer()
        )

    init {
        ioScope.launch {
            eventFlow.collect {
                when(it) {
                    SelectedTab.SettingsTab -> navigation.replaceAll(Config.Menu)
                }
            }
        }
    }

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ) = when(config) {
        Config.Design -> SettingsRootComponent.Child.Design(
            buildDesignComponent(
                componentContext = componentContext
            )
        )
        Config.Menu -> SettingsRootComponent.Child.Menu(
            buildSettingsMenuComponent(
                componentContext = componentContext,
                profileClick = { navigation.push(Config.Profile) },
                designClick = { navigation.push(Config.Design) },
                notificationClick = { navigation.push(Config.Notification) }
            )
        )
        Config.Notification -> SettingsRootComponent.Child.Notification(
            buildNotificationComponent(
                componentContext = componentContext
            )
        )
        Config.Profile -> SettingsRootComponent.Child.Profile(
            buildProfileComponent(
                componentContext = componentContext
            )
        )
    }

    override fun onBackClicked() {
        navigation.pop()
    }


    @Serializable
    sealed interface Config {
        @Serializable
        data object Menu: Config

        @Serializable
        data object Profile: Config

        @Serializable
        data object Notification: Config

        @Serializable
        data object Design: Config
    }
}