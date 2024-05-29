package ru.eetk.photo_selector

import org.koin.dsl.module
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStore
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStoreFactory

val photoSelectorModule = module {
    single<PhotoSelectorStore> {
        PhotoSelectorStoreFactory(
            storeFactory = get()
        ).create()
    }
}