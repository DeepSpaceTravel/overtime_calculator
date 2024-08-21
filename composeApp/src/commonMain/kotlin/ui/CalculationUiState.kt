package ui

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import kotlinx.datetime.LocalDate

data class CalculationUiState(
    val ocDate: MutableList<LocalDate> = mutableListOf(),
    val checkInTime: HourAndMinute = HourAndMinute(hour = 8, minute = 0),
    val checkOutTime: HourAndMinute = HourAndMinute(hour = 17, minute = 15),
    val mealCount: Byte = 0,
    val multiplayer: Float = 1.5f,
    val showDatePicker: Boolean = false,
    val showCheckInTimePicker: Boolean = false,
    val showCheckOutTimePicker: Boolean = false
)

data class HourAndMinute(
    val hour: Byte,
    val minute: Byte,
)