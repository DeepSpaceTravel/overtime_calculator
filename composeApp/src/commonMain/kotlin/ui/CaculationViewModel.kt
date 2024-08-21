package ui

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculationViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(CalculationUiState())
    val uiState: StateFlow<CalculationUiState> = _uiState.asStateFlow()

    fun showDatePicker() {
        _uiState.update { CalculationUiState(showDatePicker = true) }
    }

    fun closeDatePicker() {
        _uiState.update { CalculationUiState(showDatePicker = false) }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun updateDatePickerState(datePickerState: DatePickerState) {
        _uiState.update { CalculationUiState() }
    }

//    fun showTimePicker() {
//        _uiState.update { CalculationUiState(showTimePicker = true) }
//    }
//
//    fun closeTimePicker() {
//        _uiState.update { CalculationUiState(showTimePicker = false) }



}