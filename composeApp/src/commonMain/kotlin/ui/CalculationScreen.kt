package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import ui.components.OcMealText
import ui.components.OcTimeText
import ui.components.ocDateText
import ui.pickers.OcDatePicker
import ui.pickers.OcIconButton
import ui.pickers.OcTimePicker


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreen(calculationViewModel: CalculationViewModel) {
    val calculationUiState by calculationViewModel.uiState.collectAsState()
    var datePickerState = rememberDatePickerState()
    val checkInTimePickerState = rememberTimePickerState()
    val checkOutTimePickerState = rememberTimePickerState()

    val rowArrangement =  Arrangement.SpaceEvenly

    Row (
//        modifier = Modifier.fillMaxWidth()
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            //DatePicker starts
            ocDateText(selectedDate = calculationUiState.ocDate)

            // 上班時間
            OcTimeText(
                title = "上班時間：",
                hourAndMinute = HourAndMinute(hour = calculationUiState.checkInTime.hour, minute = calculationUiState.checkInTime.minute)
            )
            // 下班時間
            OcTimeText(
                title = "下班時間：",
                hourAndMinute = HourAndMinute(hour = calculationUiState.checkOutTime.hour, minute = calculationUiState.checkOutTime.minute)
            )

            //餐數
            OcMealText(
                mealCount = calculationUiState.mealCount
            )

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "Left"
                )
                //            Spacer(modifier = Modifier.width(200.dp))
                Text(
                    text = "Right"
                )
            }
        }

//        Icon column
        Column {
            //Date Picker
            OcIconButton(Icons.Default.Edit,
                onClickAction = {calculationViewModel.showDatePicker()},
                contentDescription = "//--Place Holder--//"
            ){
                OcDatePicker(
                    showDatePicker = calculationUiState.showDatePicker,
                    cancelAction = {calculationViewModel.closeDatePicker()},
                    confirmAction = {calculationViewModel.selectDate(datePickerState = datePickerState)
                        calculationViewModel.closeDatePicker()},
                    dismissAction = {calculationViewModel.closeDatePicker()},
                    datePickerState = datePickerState)
            }

            //Check in Time Picker
            OcIconButton(Icons.Default.Edit,
                onClickAction = {calculationViewModel.showCheckInTimePicker()},
                contentDescription = "//--Place Holder--//"
            ){
                OcTimePicker(
                    showTimePicker = calculationUiState.showCheckInTimePicker,
                    cancelAction = {calculationViewModel.closeTimePicker()},
                    confirmAction = {calculationViewModel.selectCheckInTime(timePickerState = checkInTimePickerState)
                        calculationViewModel.closeTimePicker()},
                    dismissAction = {calculationViewModel.closeTimePicker()},
                    timePickerState = checkInTimePickerState
                )
            }

            //Check out Time Picker
            OcIconButton(Icons.Default.Edit,
                onClickAction = {calculationViewModel.showCheckOutTimePicker()},
                contentDescription = "//--Place Holder--//"
            ){
                OcTimePicker(
                    showTimePicker = calculationUiState.showCheckOutTimePicker,
                    cancelAction = {calculationViewModel.closeTimePicker()},
                    confirmAction = {calculationViewModel.selectCheckOutTime(timePickerState = checkInTimePickerState)
                        calculationViewModel.closeTimePicker()},
                    dismissAction = {calculationViewModel.closeTimePicker()},
                    timePickerState = checkOutTimePickerState
                )
            }

            //Meal Picker
            Box {
                IconButton(onClick = { calculationViewModel.showMealPicker() }) {
                    Icon(Icons.Rounded.Edit,
                        contentDescription = "//Place Holder//")
                }
                DropdownMenu(
                    onDismissRequest = { calculationViewModel.closeMealPicker()},
                    expanded = calculationUiState.showMealPicker,
                    content = {
                        (0..2).forEach {
                            DropdownMenuItem(
                                text = { Text(text = "$it") },
                                onClick = {
                                    calculationViewModel.selectMealCount(it.toByte())
                                    calculationViewModel.closeMealPicker()
                                }
                            )
                        }
                    }
                )
            }

        }
    }
}

