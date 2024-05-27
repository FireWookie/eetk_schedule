package ru.eetk.launch.course.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.arkivanov.mvikotlin.extensions.coroutines.states
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import models.BranchUI
import org.koin.core.component.KoinComponent
import ru.eetk.launch.course.component.store.CourseStore
import org.koin.core.component.get
import ru.eetk.launch.course.component.store.CourseStore.*
import ru.eetk.launch.course.component.store.CourseStoreFactory

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
): ComponentContext by componentContext, SelectCourseComponent, KoinComponent {
    override fun onBackClicked() = backClick()

    override fun openMainFlow() {
        onOpenMainFlow()
    }

    private val courseStore: CourseStore = instanceKeeper.getStore(::get)
    @OptIn(ExperimentalCoroutinesApi::class)
    override val stateFlow: StateFlow<CourseStore.State> = courseStore.stateFlow

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