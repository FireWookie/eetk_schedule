package ru.eetk.schedule

import org.koin.dsl.module
import ru.eetk.schedule.component.store.ScheduleStoreFactory

val schedulePresentationModule = module {
    factory {
        ScheduleStoreFactory(
            storeFactory = get(),
        ).create()
    }
}