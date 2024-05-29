package ru.eetk.photo_selector.menu.component.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.store.create
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.eetk.photo_selector.menu.component.store.PhotoSelectorStore.*
import ru.eetk.platform.permission.delegate.ReadFilesPermissionDelegate
import ru.eetk.platform.permission.model.Permission
import ru.eetk.platform.permission.model.PermissionState
import ru.eetk.platform.permission.service.PermissionsService

class PhotoSelectorStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): PhotoSelectorStore =
        object : PhotoSelectorStore, Store<Intent, State, Label> by storeFactory.create(
            name = STORE_NAME,
            bootstrapper = BootstrapperImpl(),
            initialState = State(),
            executorFactory = PhotoSelectorStoreFactory::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed interface Action

    private class BootstrapperImpl: CoroutineBootstrapper<Action>() {
        override fun invoke() {

        }
    }

    private class ExecutorImpl: KoinComponent, CoroutineExecutor<Intent, Action, State, Message, Label>() {
        private val permissionsService by inject<PermissionsService>()
        override fun executeIntent(intent: Intent) {
            when(intent) {
                Intent.CapturePhotoByCamera -> openCamera()
                Intent.SelectPhotoByGallery -> openFilePicker()
            }
        }

        private fun openFilePicker() {
            scope.launch {
                providePermissionStorage {
                    publish(Label.PickFile)
                }
            }
        }

        private fun providePermissionStorage(
            onGranted: () -> Unit
        ) {
            scope.launch {
                permissionsService.checkPermissionFlow(Permission.READ_EXTERNAL_STORAGE)
                    .collectLatest {
                        if (it.granted()) {
                            onGranted.invoke()
                        } else if (it.denied()) {
                            permissionsService.openSettingPage(Permission.READ_EXTERNAL_STORAGE)
                        } else {
                            permissionsService.providePermission(Permission.READ_EXTERNAL_STORAGE)
                        }
                    }
            }
        }

        private fun providePermissionCamera(
            onGranted: () -> Unit
        ) {
            scope.launch {
                permissionsService.checkPermissionFlow(Permission.CAMERA)
                    .collectLatest {
                        if (it.granted()) {
                            onGranted.invoke()
                        } else if (it.denied()) {
                            permissionsService.openSettingPage(Permission.CAMERA)
                        } else {
                            permissionsService.providePermission(Permission.CAMERA)
                        }
                    }
            }
        }

        private fun openCamera() {
            providePermissionStorage {
                providePermissionCamera {
                    publish(Label.NavigateToCamera)
                }
            }
        }
    }


    private object ReducerImpl: Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when(msg) {
                Message.FilePickerState -> copy(openFilePicker = !openFilePicker)
            }

    }

    companion object {
        const val STORE_NAME = "Photo Selector Store"
    }
}