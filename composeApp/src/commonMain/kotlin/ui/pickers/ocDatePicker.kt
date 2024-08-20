package ui.pickers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
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
fun ocDatePicker(rowArrangement: Arrangement.Horizontal){

    Row(horizontalArrangement = rowArrangement) {
        var showEditDate: Boolean by remember { mutableStateOf(false) }
        var yearMonthDay: LocalDate by remember {
            mutableStateOf(
                Clock.System.now().toLocalDateTime(
                    TimeZone.currentSystemDefault()
                ).date
            )
        }
        val datePickerState = rememberDatePickerState()

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
        IconButton(
            onClick = { showEditDate = true },
            modifier = Modifier.align(Alignment.CenterVertically),
        ) {
            Icon(
                Icons.Rounded.Edit,
                contentDescription = Res.string.change_date_button.toString()
            )
        }

        //Show DatePickerDialog or not
        if (showEditDate == true) {
            DatePickerDialog(
                onDismissRequest = { showEditDate = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showEditDate = false
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
                        onClick = {
                            showEditDate = false
                        }
                    ) { Text("Cancel") }
                }
            )
            {
                DatePicker(state = datePickerState)
            }
        }
    }
}