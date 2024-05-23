package ru.eetk.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun BranchCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String
) {
    val shape: Shape = RoundedCornerShape(12.dp)
    val colors: CardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
        contentColor = MaterialTheme.colorScheme.onSurface
    )
    val elevation: CardElevation = CardDefaults.cardElevation()
    Card(
        onClick = onClick,
        modifier = modifier.height(80.dp).fillMaxWidth().padding(horizontal = 16.dp),
        elevation = elevation,
        shape = shape,
        colors = colors,
        content = { cardContent(text = text) }
    )
}
@Composable
private fun cardContent(text: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium)
        }
    )

}