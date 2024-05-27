package ru.eetk.launch.course.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    override val listCourses: List<String> = listOf("1", "2", "3", "4")

    private val _expanded = mutableStateOf(false)
    private val _selectedCourse: MutableState<String> = mutableStateOf(listCourses[0])

    override val expanded: State<Boolean> = _expanded
    override val selectedItem: State<String> = _selectedCourse

    override fun onBackClicked() = backClick()

    override fun openMainFlow() {
//        TODO("Сохранение Курса")
//        _selectedCourse.value

        onOpenMainFlow()
    }

    private val courseStore: CourseStore = instanceKeeper.getStore(::get)

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