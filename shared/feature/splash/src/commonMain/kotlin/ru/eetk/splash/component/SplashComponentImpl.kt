package ru.eetk.splash.component

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import ru.eetk.persistent.launch.showLaunch
import ru.eetk.splash.component.models.SplashResult
import ru.eetk.theme.util.BaseComponent

fun buildSplashComponent(
    componentContext: ComponentContext,
    onOpenScreen: (SplashResult) -> Unit
): SplashComponent = SplashComponentImpl(
    componentContext = componentContext,
    onOpenScreen = onOpenScreen
)


internal class SplashComponentImpl(
    componentContext: ComponentContext,
    val onOpenScreen: (SplashResult) -> Unit
): BaseComponent(componentContext), SplashComponent {

    private val dataStore: DataStore<Preferences> by inject()

    init {
        startDelay()
    }
    override fun openScreen(splashResult: SplashResult) = onOpenScreen(splashResult)
    override fun startDelay() {
        mainScope.launch {
            delay(2000)
            val showLaunch = dataStore.data.first().showLaunch
            println("Show launch info: $showLaunch")
            if (!showLaunch) {
                openScreen(SplashResult.MainFlow)
            } else {
                openScreen(SplashResult.Launch)
            }
        }
    }

}