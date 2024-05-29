package component

import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.eetk.coroutines.coroutineScope
import ru.eetk.coroutines.reLaunch
import ru.eetk.datastore.edit
import ru.eetk.launch.root.component.buildLaunchComponent
import ru.eetk.libraries.flow.FlowConstants.ROOT_FLOW
import ru.eetk.libraries.flow.FlowConstants.ROOT_FLOW_EVENT
import ru.eetk.libraries.flow.models.CaptureData
import ru.eetk.libraries.flow.models.EffectRoot
import ru.eetk.mainflow.component.MainFlowComponent
import ru.eetk.mainflow.component.buildMainFlowComponent
import ru.eetk.persistent.appearance.Theme
import ru.eetk.persistent.appearance.appTheme
import ru.eetk.persistent.launch.completeLaunch
import ru.eetk.persistent.launch.showLaunch
import ru.eetk.photo_selector.capture_photo.component.buildCapturePhotoComponent
import ru.eetk.splash.component.buildSplashComponent
import ru.eetk.splash.component.models.SplashResult
import ru.eetk.theme.util.BaseComponent

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, BaseComponent(componentContext) {

    private val navigation = StackNavigation<Config>()

    private val dataStore: DataStore<Preferences> by inject()

    private val rootFlow: MutableSharedFlow<EffectRoot> by inject(named(ROOT_FLOW))
    private val rootFlowEvent: MutableSharedFlow<CaptureData> by inject(named(ROOT_FLOW_EVENT))

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Splash,
            handleBackButton = true,
            childFactory = ::processChild,
            serializer = Config.serializer()
        )

    init {
        mainScope.launch {
            rootFlow
                .collectLatest {
                    when(it) {
                        EffectRoot.OpenCameraScreen -> navigation.pushNew(Config.Camera)
                    }
                }
        }
    }

    override val theme: StateFlow<Theme?> = dataStore.data
        .map { Theme.fromOrdinal(it.appTheme.theme) }
        .distinctUntilChanged()
        .stateIn(scope = mainScope, started = SharingStarted.Eagerly, initialValue = null)

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ) = when (config) {
        is Config.Launch -> RootComponent.Child.Launch(
            component = buildLaunchComponent(
                componentContext = componentContext,
                onOpenMainFlow = {
                    navigation.replaceAll(Config.MainFlow)
                }
            )
        )
        is Config.MainFlow -> RootComponent.Child.MainFlow(
            component = buildMainFlowComponent(
                componentContext = componentContext
            )
        )

        Config.Splash -> RootComponent.Child.Splash(
            component = buildSplashComponent(
                componentContext = componentContext,
                onOpenScreen = {
                    when(it){
                        SplashResult.Launch -> navigation.replaceAll(Config.Launch)
                        SplashResult.MainFlow -> navigation.replaceAll(Config.MainFlow)
                    }
                }
            )
        )

        Config.Camera -> RootComponent.Child.Camera(
            component = buildCapturePhotoComponent(
                componentContext = componentContext,
                onResult = {
                    rootFlowEvent.tryEmit(CaptureData.PhotoResult(it))
                    navigation.pop()
                },
                onCloseCamera = { navigation.pop() }
            )
        )
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object Launch : Config
        @Serializable
        data object MainFlow: Config

        @Serializable
        data object Splash: Config

        @Serializable
        data object Camera: Config
    }
}
