package ru.eetk.schedule.component

import com.arkivanov.decompose.ComponentContext


fun buildScheduleComponent(
    componentContext: ComponentContext
): ScheduleComponent = ScheduleComponentImpl(
    componentContext = componentContext
)

internal class ScheduleComponentImpl(
    componentContext: ComponentContext
): ScheduleComponent, ComponentContext by componentContext {

}