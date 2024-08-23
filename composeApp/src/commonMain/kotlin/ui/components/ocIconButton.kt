package ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ocIconButton(icon: ImageVector,
                 onClickAction: () -> Unit,
                 contentDescription: String,
                 content: @Composable () -> Unit,
                 modifier: Modifier = Modifier) {
    IconButton(onClick = onClickAction,
        modifier = modifier){
        Icon(
            icon,
            contentDescription = contentDescription
        )
    }
    content()
}