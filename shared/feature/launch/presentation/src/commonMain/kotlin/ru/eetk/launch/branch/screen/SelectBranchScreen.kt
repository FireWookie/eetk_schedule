package ru.eetk.launch.branch.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.branch_eto
import eetk_app.shared.compose.resources.generated.resources.branch_mto
import eetk_app.shared.compose.resources.generated.resources.select_branch
import models.BranchUI
import org.jetbrains.compose.resources.stringResource
import ru.eetk.components.cards.BranchCard
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.launch.branch.component.SelectBranchComponent

@Composable
internal fun SelectBranchScreen(component: SelectBranchComponent) {
    CenteredColumn(
        modifier = Modifier.padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = null,
            modifier = Modifier.height(120.dp).width(140.dp)
        )
        Text(
            text = stringResource(Res.string.select_branch),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            BranchCard(
                onClick = { component.onSelectBranch(BranchUI.ETO) },
                text = stringResource(Res.string.branch_eto)
            )
            BranchCard(
                onClick = { component.onSelectBranch(BranchUI.MTO) },
                text = stringResource(Res.string.branch_mto)
            )
        }
    }

}