package ui

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@OptIn(ExperimentalMaterial3Api::class)
class CalculationViewModel: ViewModel (){
    private val _uiState = MutableStateFlow(CalculationUiState())
    val uiState: StateFlow<CalculationUiState> = _uiState.asStateFlow()

    fun showDatePicker() {
        _uiState.update { it.copy(showDatePicker = true) }
    }

    fun closeDatePicker() {
        _uiState.update { it.copy(showDatePicker = false) }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun saveDailyInfo(datePickerState: DatePickerState,
                      timePickerState: TimePickerState){
//        _uiState.value.ocDate.add(Instant
//            .fromEpochMilliseconds(datePickerState.selectedDateMillis!!)
//            .toLocalDateTime(TimeZone.currentSystemDefault())
//            .date)
//        println(_uiState.value.ocDate.size)
    }

    fun showTimePicker() {
        _uiState.update { it.copy(showTimePicker = true) }
    }

    fun selectCheckInTime(timePickerState: TimePickerState) {
        _uiState.update { it.copy(checkInTime = HourAndMinute(hour = timePickerState.hour.toByte(), minute = timePickerState.minute.toByte()))}
    }

    fun selectCheckOutTime() {

    }

    fun closeTimePicker() {
        _uiState.update { it.copy(showTimePicker = false) }
    }


}