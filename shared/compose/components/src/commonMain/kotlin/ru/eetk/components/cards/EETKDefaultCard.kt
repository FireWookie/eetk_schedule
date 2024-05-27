package ru.eetk.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun EETKDefaultCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    cardContent: @Composable (ColumnScope.() -> Unit) =  { cardDefaultContent(text = text) }
) {
    val shape: Shape = MaterialTheme.shapes.large
    val colors: CardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
        contentColor = MaterialTheme.colorScheme.onSurface
    )
    val elevation: CardElevation = CardDefaults.cardElevation()
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier) ,
        elevation = elevation,
        shape = shape,
        colors = colors,
        content = cardContent
    )
}

@Composable
private fun cardDefaultContent(text: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    )

}