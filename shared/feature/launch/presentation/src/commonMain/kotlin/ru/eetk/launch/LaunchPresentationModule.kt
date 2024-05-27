package ru.eetk.launch

import com.arkivanov.mvikotlin.core.store.StoreFactory
import org.koin.dsl.module
import ru.eetk.launch.course.component.store.CourseStoreFactory

val launchPresentationModule = module {
    factory {
        CourseStoreFactory(
            storeFactory = get(),
        ).create()
    }
}