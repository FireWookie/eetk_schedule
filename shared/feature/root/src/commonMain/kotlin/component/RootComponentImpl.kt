package component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import ru.eetk.launch.root.component.buildLaunchComponent
import ru.eetk.mainflow.component.MainFlowComponent
import ru.eetk.mainflow.component.buildMainFlowComponent

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Launch,
            handleBackButton = true,
            childFactory = ::processChild,
            serializer = Config.serializer()
        )

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ) = when (config) {
        is Config.Launch -> RootComponent.Child.Launch(
            component = buildLaunchComponent(
                componentContext = componentContext,
                onOpenMainFlow = { navigation.replaceAll(Config.MainFlow) }
            )
        )
        is Config.MainFlow -> RootComponent.Child.MainFlow(
            component = buildMainFlowComponent(
                componentContext = componentContext
            )
        )
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object Launch : Config
        @Serializable
        data object MainFlow: Config
    }
}
