package ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import ui.pickers.ocTimePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ocTimeText(title: String,
               initialHour: Byte,
               initalMinute: Byte,
               showTimePicker: Boolean,
               confirmAction: () -> Unit,
               cancelAction: () -> Unit,
               dismissAction: () -> Unit,
               timePickerState: TimePickerState,
               modifier: Modifier = Modifier) {

    var hour by remember { mutableStateOf(initialHour.toString()) }
    var minute by remember { mutableStateOf(initalMinute.toString()) }

    //    Check the length of Hour and Minute
    if (hour.length == 1) {
        hour = StringBuilder()
            .append("0")
            .append(hour)
            .toString()
    }
    if (minute.length == 1) {
        minute = StringBuilder()
            .append("0")
            .append(minute)
            .toString()
    }

    Text(
        text = buildAnnotatedString {
            append(title)
            append(hour)
            append(":")
            append(minute)
        },
        modifier = modifier
    )

    ocTimePicker(showTimePicker = showTimePicker,
        confirmAction = {confirmAction()
            hour = timePickerState.hour.toString()
            minute = timePickerState.minute.toString()},
        cancelAction = cancelAction,
        dismissAction = dismissAction,
        timePickerState = timePickerState)
}