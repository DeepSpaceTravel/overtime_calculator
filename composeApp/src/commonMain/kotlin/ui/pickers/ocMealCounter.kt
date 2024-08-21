package ui.pickers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ocMealCounter(rowArrangement: Arrangement.Horizontal,
                  mealCount: Byte) {
    var showMealCounter: Boolean by remember { mutableStateOf(false) }
    var mealCount: Byte by remember { mutableStateOf(mealCount) }

    Row(horizontalArrangement = rowArrangement) {
        val modifier = Modifier.align(Alignment.CenterVertically)

        Text(
            text = "加班餐數：",
            modifier = modifier
        )
        Text(
            text = mealCount.toString(),
            modifier = modifier
        )
        Box {
            IconButton(onClick = { showMealCounter = true}) {
                Icon(Icons.Rounded.Edit,
                    contentDescription = "//Place Holder//")
            }
            DropdownMenu(
                onDismissRequest = {
                    showMealCounter = false

                },
                expanded = showMealCounter,
                modifier = modifier,
                content = {
                    (0..2).forEach {
                        DropdownMenuItem(
                            text = { Text(text = "$it") },
                            onClick = {
                                showMealCounter = false
                                mealCount = it.toByte()
                            }
                        )
                    }
                }
            )
        }

    }
}