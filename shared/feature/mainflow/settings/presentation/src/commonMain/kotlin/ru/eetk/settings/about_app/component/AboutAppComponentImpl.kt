package ru.eetk.settings.about_app.component

import com.arkivanov.decompose.ComponentContext
import ru.eetk.theme.util.BaseComponent

internal fun buildAboutAppComponent(
    componentContext: ComponentContext,
    backClick: () -> Unit
): AboutAppComponent = AboutAppComponentImpl(
    componentContext = componentContext,
    backClick = backClick
)

/**
 * AboutAppComponentImpl - компонент экрана AboutAppScreen
 * @param componentContext - контекст decompose
 * @param backClick - событие клика назад
 */

internal class AboutAppComponentImpl(
    componentContext: ComponentContext,
    val backClick: () -> Unit
): AboutAppComponent, BaseComponent(componentContext = componentContext) {
    override fun onBackClicked() = backClick.invoke()

    override fun onTGClicked() {}
}