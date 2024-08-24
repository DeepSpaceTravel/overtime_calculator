package ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.buildAnnotatedString

@Composable
fun OcMealText(mealCount: Byte) {
    Text(
        text = buildAnnotatedString {
            append("加班餐數：")
            append(mealCount.toString())
        }
    )
}