package component

import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import ru.eetk.coroutines.coroutineScope
import ru.eetk.coroutines.reLaunch
import ru.eetk.datastore.edit
import ru.eetk.launch.root.component.buildLaunchComponent
import ru.eetk.mainflow.component.MainFlowComponent
import ru.eetk.mainflow.component.buildMainFlowComponent
import ru.eetk.persistent.launch.completeLaunch
import ru.eetk.persistent.launch.showLaunch

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext, KoinComponent {

    private val dataStore: DataStore<Preferences> by inject()
    private val coroutineScope = coroutineScope()

    init {
        runBlocking {
            dataStore.edit { // TODO Remove
                completeLaunch()
            }
            if (!dataStore.data.first().showLaunch) {
                navigation.replaceAll(Config.MainFlow)
            } else {
                navigation.replaceAll(Config.Launch)
            }
        }
    }

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.MainFlow,
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
                onOpenMainFlow = {
                    coroutineScope.launch {
                        dataStore.edit {
                            completeLaunch()
                        }
                    }
                }
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
