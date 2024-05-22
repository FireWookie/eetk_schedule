package ru.eetk.launch

import org.koin.dsl.module
import ru.eetk.launch.course.store.CourseStoreFactory

val launchPresentationModule = module {
    single {
        CourseStoreFactory(
            storeFactory = get(),
        ).create()
    }
}