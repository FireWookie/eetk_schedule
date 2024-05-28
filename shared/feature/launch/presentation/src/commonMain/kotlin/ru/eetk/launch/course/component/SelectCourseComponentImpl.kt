package ru.eetk.launch.course.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.binder.BinderLifecycleMode
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import models.BranchUI
import org.koin.core.component.KoinComponent
import ru.eetk.launch.course.component.store.CourseStore
import org.koin.core.component.get
import ru.eetk.launch.course.component.store.CourseStore.*
import ru.eetk.theme.util.BaseComponent

fun buildSelectCourseComponent(
    componentContext: ComponentContext,
    branchUI: BranchUI,
    backClick: () -> Unit,
    onOpenMainFlow: () -> Unit
): SelectCourseComponent = SelectCourseComponentImpl(
    componentContext = componentContext,
    branchUI = branchUI,
    backClick = backClick,
    onOpenMainFlow = onOpenMainFlow
)

internal class SelectCourseComponentImpl(
    componentContext: ComponentContext,
    private val branchUI: BranchUI,
    private val backClick: () -> Unit,
    private val onOpenMainFlow: () -> Unit
): BaseComponent(componentContext), SelectCourseComponent, KoinComponent {
    override fun onBackClicked() = backClick()

    private val courseStore: CourseStore = instanceKeeper.getStore(::get)
    @OptIn(ExperimentalCoroutinesApi::class)
    override val stateFlow: StateFlow<State> = courseStore.stateFlow

    init {
        bind(lifecycle, BinderLifecycleMode.CREATE_DESTROY) {
            courseStore.labels bindTo ::bindStoreLabel
        }
    }

    override fun saveData() {
        courseStore.accept(
            Intent.SaveInfoLaunch(
                college = branchUI.collage,
            )
        )
    }

    private fun bindStoreLabel(label: Label) {
        when(label) {
            Label.OpenMainFlow -> onOpenMainFlow()
        }
    }

    override fun onDDMDismissRequest() {
        courseStore.accept(Intent.ChangeExpanded)
    }

    override fun onDDMChangeItem(item: Pair<Int, StringResource>) {
        courseStore.accept(Intent.ChangeSelectedCourse(item))
    }

    override fun onDDMClicked() {
        courseStore.accept(Intent.ChangeExpanded)
    }
}