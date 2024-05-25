package ru.eetk.schedule.component

import com.arkivanov.decompose.ComponentContext
import ru.eetk.theme.util.BaseComponent


fun buildScheduleComponent(
    componentContext: ComponentContext
): ScheduleComponent = ScheduleComponentImpl(
    componentContext = componentContext
)

internal class ScheduleComponentImpl(
    componentContext: ComponentContext
): ScheduleComponent, BaseComponent(componentContext) {

}