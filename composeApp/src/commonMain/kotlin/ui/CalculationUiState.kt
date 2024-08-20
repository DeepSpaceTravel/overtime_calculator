package ui

import kotlinx.datetime.LocalDate

data class CalculationUiState(
    val date: MutableList<LocalDate> = mutableListOf(),
    val checkInTime: HourAndMinute = HourAndMinute(hour = 8, minute = 0),
    val checkOutTime: HourAndMinute = HourAndMinute(hour = 17, minute = 15),
    val mealCount: Byte = 0,
    val multiplayer: Float = 1.5f,
)

data class HourAndMinute(
    val hour: Byte,
    val minute: Byte,
)