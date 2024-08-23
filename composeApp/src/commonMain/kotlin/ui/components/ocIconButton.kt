package ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun OcIconButton(icon: ImageVector,
                 onClickAction: () -> Unit,
                 contentDescription: String,
                 modifier: Modifier = Modifier,
                 content: @Composable (() -> Unit)? = null) {
    IconButton(onClick = onClickAction,
        modifier = modifier){
        Icon(
            icon,
            contentDescription = contentDescription
        )
    }
    if (content != null) {
        content()
    }
}