package ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toDateTimePeriod
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import overtime_calculator.composeapp.generated.resources.Res
import overtime_calculator.composeapp.generated.resources.change_date_button
import overtime_calculator.composeapp.generated.resources.day
import overtime_calculator.composeapp.generated.resources.hours_more_work
import overtime_calculator.composeapp.generated.resources.month
import overtime_calculator.composeapp.generated.resources.selected_date_is
import overtime_calculator.composeapp.generated.resources.year
import kotlin.time.toDuration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreenLayout() {
    var overworkedHour: String by rememberSaveable{ mutableStateOf("") }
//    var checkInTime:
//    var checkOutRTime:
    val multiplier: Float by remember { mutableStateOf(1.0F)}
    var numberOfMeals: String by remember { mutableStateOf("") }

    Column {
//        DatePicker starts
        Row(horizontalArrangement = Arrangement.SpaceEvenly){
            var showEditDate: Boolean by remember { mutableStateOf(false) }
            var yearMonthDay: LocalDate by remember { mutableStateOf(Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date) }
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
            if (showEditDate == true) {
                DatePickerDialog(
                    onDismissRequest = { showEditDate = false },
                    confirmButton = { TextButton(
                        onClick = {
                            showEditDate = false
                            yearMonthDay = Instant.fromEpochMilliseconds(datePickerState.selectedDateMillis!!).toLocalDateTime(TimeZone.currentSystemDefault()).date
                        }
                    ) { Text("OK") }
                    },
                    dismissButton = { TextButton(
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
//    DatePicker ends
        // 加班時數
        InputTextField(
            label = Res.string.hours_more_work,
            onValueChanged = {
                if (it.toIntOrNull() != null || it == "") {
                    overworkedHour = it
                }
            },
            value = overworkedHour,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            enabledOrNot = true,
            modifier = Modifier
        )
}















@Composable
fun InputTextField(
    label: StringResource,
    onValueChanged: (String) -> Unit,
    value: String,
    modifier: Modifier,
    keyboardOptions: KeyboardOptions,
    enabledOrNot: Boolean,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(stringResource(label))},
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        enabled = enabledOrNot,
    )
}
