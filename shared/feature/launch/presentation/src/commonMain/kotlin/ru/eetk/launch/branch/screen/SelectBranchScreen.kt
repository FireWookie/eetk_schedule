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
import dev.icerock.moko.resources.compose.stringResource
import models.BranchUI
import ru.eetk.components.cards.EETKBranchCard
import ru.eetk.components.layout.CenteredColumn
import ru.eetk.launch.branch.component.SelectBranchComponent
import ru.eetk.resources.EetkRes

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
            text = stringResource(EetkRes.strings.select_branch),
            style = MaterialTheme.typography.headlineLarge
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            EETKBranchCard(
                onClick = { component.onSelectBranch(BranchUI.ETO) },
                text = stringResource(EetkRes.strings.branch_eto)
            )
            EETKBranchCard(
                onClick = { component.onSelectBranch(BranchUI.MTO) },
                text = stringResource(EetkRes.strings.branch_mto)
            )
        }
    }

}