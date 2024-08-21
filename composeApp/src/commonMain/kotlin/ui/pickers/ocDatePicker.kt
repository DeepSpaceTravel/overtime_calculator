package ui.pickers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringResource
import overtime_calculator.composeapp.generated.resources.Res
import overtime_calculator.composeapp.generated.resources.change_date_button
import overtime_calculator.composeapp.generated.resources.selected_date_is

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ocDatePicker(rowArrangement: Arrangement.Horizontal,
                 showDatePicker: Boolean,
                 onDismissRequestAction: () -> Unit,
                 onClickAction: () -> Unit,
                 onDismissButtonAction: () -> Unit){
    val datePickerState = rememberDatePickerState()

    Row(horizontalArrangement = rowArrangement,) {
        var yearMonthDay: LocalDate by remember {
            mutableStateOf(
                Clock.System.now().toLocalDateTime(
                    TimeZone.currentSystemDefault()
                ).date
            )
        }

        Text(
            text = buildAnnotatedString {
                append((stringResource(Res.string.selected_date_is)))
                append(yearMonthDay.toString())
                append(" (")
                append(yearMonthDay.dayOfWeek.toString().take(3))
                append(")")

            },
            modifier = Modifier.align(Alignment.CenterVertically),
        )

        //Show DatePickerDialog or not
        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = onDismissRequestAction,
                confirmButton = {
                    TextButton(
                        onClick = {
                            onClickAction()
                            val date = datePickerState.selectedDateMillis
                            if (date != null) {
                                yearMonthDay =
                                    Instant.fromEpochMilliseconds(date)
                                        .toLocalDateTime(TimeZone.currentSystemDefault()).date
                            }
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
}