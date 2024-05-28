package ru.eetk.settings

import org.koin.dsl.module
import ru.eetk.settings.design.component.store.DesignStoreFactory
import ru.eetk.settings.notification.component.store.NotificationStoreFactory

val settingsPresentationModule = module {
    factory {
        NotificationStoreFactory(
            storeFactory = get(),
        ).create()
    }
    factory {
        DesignStoreFactory(
            storeFactory = get()
        ).create()
    }
}