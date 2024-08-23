package ui.pickers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringResource
import overtime_calculator.composeapp.generated.resources.Res
import overtime_calculator.composeapp.generated.resources.selected_date_is

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcDatePicker(showDatePicker: Boolean,
                 onDismissRequestAction: () -> Unit,
                 onClickAction: () -> Unit,
                 onDismissButtonAction: () -> Unit,
                 datePickerState: DatePickerState){

    //Show DatePickerDialog or not
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = onDismissRequestAction,
            confirmButton = {
                TextButton(
                    onClick = {
                        onClickAction()
                    }
                ) { Text("OK") }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissButtonAction
                ) { Text("Cancel") }
            }
        )
        {
            DatePicker(state = datePickerState)
        }
    }
}