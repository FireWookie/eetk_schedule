package ru.eetk.settings

import org.koin.dsl.module
import ru.eetk.settings.notification.component.store.NotificationStoreFactory

val settingsPresentationModule = module {
    factory {
        NotificationStoreFactory(
            storeFactory = get(),
        ).create()
    }
}