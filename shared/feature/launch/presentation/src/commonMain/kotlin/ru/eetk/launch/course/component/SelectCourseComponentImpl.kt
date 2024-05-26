package ru.eetk.launch.course.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import models.BranchUI
import org.koin.core.component.KoinComponent
import ru.eetk.launch.course.store.CourseStore
import org.koin.core.component.get
import ru.eetk.launch.course.store.CourseStoreFactory

fun buildSelectCourseComponent(
    componentContext: ComponentContext,
    branchUI: BranchUI,
    onOpenMainFlow: () -> Unit,
    backClick: () -> Unit
): SelectCourseComponent = SelectCourseComponentImpl(
    componentContext = componentContext,
    branchUI = branchUI,
    onOpenMainFlow = onOpenMainFlow,
    backClick = backClick
)

internal class SelectCourseComponentImpl(
    componentContext: ComponentContext,
    private val branchUI: BranchUI,
    private val onOpenMainFlow: () -> Unit,
    private val backClick: () -> Unit
): ComponentContext by componentContext, SelectCourseComponent, KoinComponent {

    private val _expanded = mutableStateOf(false)
    private val _selectedCourse: MutableState<String> = mutableStateOf("1")

    override val expanded: State<Boolean> = _expanded
    override val selectedItem: State<String> = _selectedCourse

    override fun onBackClicked() = backClick()

    override fun openMainFlow() {
//        TODO("Сохранение Курса")
//        _selectedCourse.value

        onOpenMainFlow()
    }

    private val courseStore: CourseStore = instanceKeeper.getStore(::get)

//    override fun selectCourse() {
//        onOpenMainFlow.invoke()
//    }

    override fun onDDMDismissRequest() {
       _expanded.value = false
    }

    override fun onDDMChangeItem(itemId: String) {
        _selectedCourse.value = itemId
        onDDMDismissRequest()
    }

    override fun onDDMClicked() {
        _expanded.value = true
    }
}