package ru.eetk.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ru.eetk.components.buttons.EETKPrimaryFilledButton
import ru.eetk.components.buttons.PrimaryBackButton

@Composable
fun EETKDialog(
    title: String,
    desc: String,
    buttonText: String,
    tfPlaceHolder: String,
    tfValue: String,
    canGoBack: Boolean = true,
    tfOnValueChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit = {
        EETKDialogContent(
            title = title,
            desc = desc,
            buttonText = buttonText,
            tfPlaceHolder = tfPlaceHolder,
            tfValue = tfValue,
            tfOnValueChange = tfOnValueChange,
            onButtonClick = onButtonClick,
            onDismissRequest = onDismissRequest
        )
    },
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        content = content,
        properties = DialogProperties(
            dismissOnBackPress = canGoBack,
            dismissOnClickOutside = canGoBack
        )
    )
}

@Composable
private fun EETKDialogContent(
    title: String,
    desc: String,
    buttonText: String,
    tfPlaceHolder: String,
    tfValue: String,
    tfOnValueChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    val shape = RoundedCornerShape(40.dp)
    val onContainerColor = MaterialTheme.colorScheme.onSecondaryContainer
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer, shape = shape)
    ) {
        PrimaryBackButton(
            icon = Icons.Outlined.Close,
            onClick = onDismissRequest,
            modifier = Modifier.padding(10.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            //        TitleBar
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = onContainerColor,
                )
            }
//            Content
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = desc,
                    style = MaterialTheme.typography.bodySmall,
                    color = onContainerColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(200.dp)
                )


                OutlinedTextField(
                    value = tfValue,
                    onValueChange = tfOnValueChange,
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    placeholder = {
                        Text(
                            text = tfPlaceHolder,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                EETKPrimaryFilledButton(
                    text = buttonText,
                    onClick = onButtonClick,
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}