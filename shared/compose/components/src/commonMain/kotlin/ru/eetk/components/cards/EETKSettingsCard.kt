package ru.eetk.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun EETKSettingCard(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cardContent: @Composable (ColumnScope.() -> Unit) = { SettingsEETKCardContent(text = text, icon = icon) }
) = EETKDefaultCard(
    onClick = onClick,
    modifier = modifier.height(70.dp),
    text = text,
    cardContent = cardContent
)

@Composable
private fun SettingsEETKCardContent(text: String, icon: ImageVector) {
    Row(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(20.dp),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
        )
    }
}