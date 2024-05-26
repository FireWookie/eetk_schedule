package ru.eetk.launch.course.component

import androidx.compose.runtime.State

interface SelectCourseComponent {

    val expanded: State<Boolean>

    val selectedItem: State<String>

    fun onBackClicked()

    fun openMainFlow()

    fun onDDMDismissRequest()

    fun onDDMChangeItem(itemId: String)

    fun onDDMClicked()
}