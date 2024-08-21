package ui.pickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import overtime_calculator.composeapp.generated.resources.Res
import overtime_calculator.composeapp.generated.resources.change_date_button

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ocTimePicker(
    rowArrangement: Arrangement.HorizontalOrVertical,
    title: String,
    hour: Byte,
    minute: Byte) {

    var showTimePicker: Boolean by remember { mutableStateOf( false) }
    val timePickerState = rememberTimePickerState()
    var hour by remember { mutableStateOf(hour.toString()) }
    var minute by remember { mutableStateOf(minute.toString()) }

//    Check the length of Hour and Minute
    if (hour.length == 1){
        hour = StringBuilder()
            .append("0")
            .append(hour)
            .toString()
    }
    if (minute.length == 1){
        minute = StringBuilder()
            .append("0")
            .append(minute)
            .toString()
    }

    //Composable starts here
    Row(horizontalArrangement = rowArrangement) {
        val modifier = Modifier.align(Alignment.CenterVertically)

        Text(
            text = title,
            modifier = modifier,
        )
        Text(
            text = buildAnnotatedString {
                append(hour)
                append(":")
                append(minute)
            },
            modifier = modifier
        )
        IconButton(
            onClick = { showTimePicker = true },
            modifier = modifier,
        ) {
            Icon(
                Icons.Rounded.Edit,
                contentDescription = Res.string.change_date_button.toString()
            )
        }
    }

    if (showTimePicker){

        TimePickerDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = { TextButton(
                onClick = {
                    showTimePicker = false
                    hour = timePickerState.hour.toString()
                    minute = timePickerState.minute.toString()
                }
            ) { Text("OK") } },
            dismissButton = { TextButton(
                onClick = {
                    showTimePicker = false
                }
            ) { Text("Cancel") } }
        )
        {
            TimePicker(state = timePickerState)
        }
    }
}

@Composable
private fun TimePickerDialog(
    title: String = "Select Time",
    onDismissRequest: () -> Unit,
    confirmButton: @Composable (() -> Unit),
    dismissButton: @Composable (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = containerColor
                ),
            color = containerColor
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}