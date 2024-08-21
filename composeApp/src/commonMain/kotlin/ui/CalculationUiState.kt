package ui

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.remember
import kotlinx.datetime.LocalDate

data class CalculationUiState @OptIn(ExperimentalMaterial3Api::class) constructor(
    val date: MutableList<LocalDate> = mutableListOf(),
    val checkInTime: HourAndMinute = HourAndMinute(hour = 8, minute = 0),
    val checkOutTime: HourAndMinute = HourAndMinute(hour = 17, minute = 15),
    val mealCount: Byte = 0,
    val multiplayer: Float = 1.5f,
    val showDatePicker: Boolean = false,
    val showTimePicker: Boolean = false,
//    val datePickerState: DatePickerState,
//    val timePickerState: TimePickerState
)

data class HourAndMinute(
    val hour: Byte,
    val minute: Byte,
)