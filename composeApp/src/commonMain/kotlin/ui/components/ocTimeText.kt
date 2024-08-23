package ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.coroutines.flow.flowOf
import ui.HourAndMinute
import ui.pickers.ocTimePicker

@Composable
fun ocTimeText(title: String,
               hourAndMinute: HourAndMinute,
               modifier: Modifier = Modifier) {


    println("hourAndMinute is: $hourAndMinute")

    var hourStr = hourAndMinute.hour.toString()
    var minuteStr = hourAndMinute.minute.toString()

    //    Check the length of Hour and Minute
    if (hourStr.length == 1) {
        hourStr= StringBuilder()
            .append("0")
            .append(hourStr)
            .toString()
    }
    if (minuteStr.length == 1) {
        minuteStr = StringBuilder()
            .append("0")
            .append(minuteStr)
            .toString()
    }

    Text(
        text = buildAnnotatedString {
            append(title)
            append(hourStr)
            append(":")
            append(minuteStr)
        },
        modifier = modifier
    )
}