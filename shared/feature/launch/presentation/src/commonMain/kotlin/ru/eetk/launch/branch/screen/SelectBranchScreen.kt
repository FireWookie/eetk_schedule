package ru.eetk.launch.branch.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import models.BranchUI
import ru.eetk.components.buttons.FilledButton
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.launch.branch.component.SelectBranchComponent

@Composable
internal fun SelectBranchScreen(component: SelectBranchComponent) {
    CenteredColumn {
        Text("Branch")
        FilledButton({
            component.onSelectBranch(BranchUI.MTO)
        }) {}
    }

}