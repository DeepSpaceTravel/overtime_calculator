package ui

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class CalculationUiState(
    val ocDate: LocalDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date,
    val checkInTime: HourAndMinute = HourAndMinute(hour = 8, minute = 0),
    val checkOutTime: HourAndMinute = HourAndMinute(hour = 17, minute = 15),
    val mealCount: Byte = 0,
    val multiplayer: Float = 1.5f,
    val showDatePicker: Boolean = false,
    val showTimePicker: Boolean = false
)

data class HourAndMinute(
    val hour: Byte,
    val minute: Byte,
)