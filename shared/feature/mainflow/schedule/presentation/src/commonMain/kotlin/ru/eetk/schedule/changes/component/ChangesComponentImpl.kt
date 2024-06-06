package ru.eetk.schedule.changes.component

import com.arkivanov.decompose.ComponentContext
import ru.eetk.theme.util.BaseComponent


fun buildChangesComponent(
    componentContext: ComponentContext
): ChangesComponent = ChangesComponentImpl(
    componentContext = componentContext
)
internal class ChangesComponentImpl(
    componentContext: ComponentContext
): ChangesComponent, BaseComponent(componentContext) {
    override val asda: String
        get() = "changes"
}