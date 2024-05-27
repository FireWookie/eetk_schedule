package ru.eetk.components.cards

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EETKBranchCard(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = EETKDefaultCard(
    onClick = onClick,
    modifier = modifier.height(80.dp),
    text = text,
)