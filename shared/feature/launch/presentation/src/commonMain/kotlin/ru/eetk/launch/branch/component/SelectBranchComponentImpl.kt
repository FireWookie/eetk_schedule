package ru.eetk.launch.branch.component

import com.arkivanov.decompose.ComponentContext
import models.BranchUI

fun buildSelectBranchComponent(
    componentContext: ComponentContext,
    onSelectBranch: (BranchUI) -> Unit
): SelectBranchComponent = SelectBranchComponentImpl(
    componentContext = componentContext,
    selectBranch = onSelectBranch
)

internal class SelectBranchComponentImpl(
    componentContext: ComponentContext,
    private val selectBranch: (BranchUI) -> Unit
): ComponentContext by componentContext, SelectBranchComponent {

    override fun onSelectBranch(branch: BranchUI) = selectBranch(branch)

}