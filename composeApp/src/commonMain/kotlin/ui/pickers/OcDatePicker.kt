package ui.pickers

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcDatePicker(showDatePicker: Boolean,
                 dismissAction: () -> Unit,
                 confirmAction: () -> Unit,
                 cancelAction: () -> Unit,
                 datePickerState: DatePickerState){

    //Show DatePickerDialog or not
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = dismissAction,
            confirmButton = {
                TextButton(
                    onClick = {
                        confirmAction()
                    }
                ) { Text("OK") }
            },
            dismissButton = {
                TextButton(
                    onClick = cancelAction
                ) { Text("Cancel") }
            }
        )
        {
            DatePicker(state = datePickerState)
        }
    }
}