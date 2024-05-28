package ru.eetk.settings.design.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import ru.eetk.persistent.appearance.Theme
import ru.eetk.settings.design.component.store.DesignStore
import ru.eetk.settings.design.component.store.DesignStore.*
import ru.eetk.theme.util.BaseComponent


internal fun buildDesignComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit
): DesignComponent = DesignComponentImpl(
    componentContext = componentContext,
    backClick = backClick
)
internal class DesignComponentImpl(
    componentContext: ComponentContext,
    private val backClick: () -> Unit

): DesignComponent, BaseComponent(componentContext){

    private val designStore: DesignStore = instanceKeeper.getStore(::get)
    @OptIn(ExperimentalCoroutinesApi::class)
    override val stateFlow: StateFlow<State> = designStore.stateFlow

    override fun onBackClicked() = backClick()

    override fun onThemeClicked() {
        designStore.accept(Intent.ChangeExpanded)
    }

    override fun onChangeDynTheme(state: Boolean) {
        designStore.accept(Intent.ChangeDynamicColors)
    }

    override fun onChangeThemeItem(theme: Pair<Theme, StringResource>) {
        
        designStore.accept(Intent.ChangeSelectedTheme(theme = theme))
    }
}