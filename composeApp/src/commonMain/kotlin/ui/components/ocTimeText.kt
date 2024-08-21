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
               showTimePicker: Boolean,
               confirmAction: () -> Unit,
               cancelAction: () -> Unit,
               dismissAction: () -> Unit,
               timePickerState: TimePickerState,
               modifier: Modifier = Modifier) {

    //    Check the length of Hour and Minute
    if (timePickerState.hour.toString().length == 1){
      StringBuilder()
          .append("0")
          .append(timePickerState.hour.toString())
          .toString()
    }
    if (timePickerState.minute.toString().length == 1){
        StringBuilder()
            .append("0")
            .append(timePickerState.minute.toString())
            .toString()
    }

    Text(
        text = title,
        modifier = modifier,
    )
    Text(
        text = buildAnnotatedString {
            append(timePickerState.hour.toString())
            append(":")
            append(timePickerState.minute.toString())
        },
        modifier = modifier
    )

    ocTimePicker(showTimePicker = showTimePicker,
        timePickerState = timePickerState,
        confirmAction = confirmAction,
        cancelAction = cancelAction,
        dismissAction = dismissAction
    )
}