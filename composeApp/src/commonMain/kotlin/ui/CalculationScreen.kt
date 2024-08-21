package ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import overtime_calculator.composeapp.generated.resources.Res
import overtime_calculator.composeapp.generated.resources.change_date_button
import overtime_calculator.composeapp.generated.resources.day
import overtime_calculator.composeapp.generated.resources.hours_more_work
import overtime_calculator.composeapp.generated.resources.month
import overtime_calculator.composeapp.generated.resources.selected_date_is
import overtime_calculator.composeapp.generated.resources.year
import ui.components.ocDateText
import ui.components.ocIconButton
import ui.components.ocTimeText
import ui.pickers.ocMealCounter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreen(calculationViewModel: CalculationViewModel = CalculationViewModel()) {
    val calculationUiState by calculationViewModel.uiState.collectAsState()
    val datePickerState = rememberDatePickerState()
    val checkInTimePickerState = rememberTimePickerState()
    val checkOutTimePickerState = rememberTimePickerState()

    val rowArrangement =  Arrangement.SpaceEvenly

    Row (
//        modifier = Modifier.fillMaxWidth()
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            //DatePicker starts
            ocDateText(confirmAction = {calculationViewModel.closeDatePicker()
//                                       calculationViewModel.saveDailyInfo(datePickerState, timePickerState)
                                       },
                cancelAction = {calculationViewModel.closeDatePicker()},
                dismissAction = {calculationViewModel.closeDatePicker()},
                datePickerState = datePickerState,
                showDatePicker = calculationUiState.showDatePicker)

            // 上班時間
            ocTimeText(
                title = "上班時間：",
                initialHour = calculationUiState.checkInTime.hour,
                initalMinute = calculationUiState.checkInTime.minute,
                showTimePicker = calculationUiState.showCheckInTimePicker,
                confirmAction = {calculationViewModel.closeTimePicker()},
                cancelAction = {calculationViewModel.closeTimePicker()},
                dismissAction = {calculationViewModel.closeTimePicker()},
                timePickerState = checkInTimePickerState
            )
            // 下班時間
            ocTimeText(
                title = "下班時間：",
                initialHour = calculationUiState.checkOutTime.hour,
                initalMinute = calculationUiState.checkOutTime.minute,
                showTimePicker = calculationUiState.showCheckOutTimePicker,
                confirmAction = {calculationViewModel.closeTimePicker()},
                cancelAction = {calculationViewModel.closeTimePicker()},
                dismissAction = {calculationViewModel.closeTimePicker()},
                timePickerState = checkOutTimePickerState
            )

            //餐數
            ocMealCounter(
                rowArrangement = rowArrangement,
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
            ocIconButton(Icons.Default.Edit,
                onClickAction = {calculationViewModel.showDatePicker()},
                contentDescription = "//--Place Holder--//")
            //Check in Time Picker
            ocIconButton(Icons.Default.Edit,
            onClickAction = {calculationViewModel.showCheckInTimePicker()},
            contentDescription = "//--Place Holder--//")

            //Check out Time Picker
            ocIconButton(Icons.Default.Edit,
                onClickAction = {calculationViewModel.showCheckOutTimePicker()},
                contentDescription = "//--Place Holder--//")

            //Meal Picker
//            ocIconButton(Icons.Default.Edit,
//                onClickAction = { TODO("Implement Meal Counter") },
//                contentDescription = "//--Place Holder--//")
            Text(
                text = "Hi"
            )
        }
    }
}

