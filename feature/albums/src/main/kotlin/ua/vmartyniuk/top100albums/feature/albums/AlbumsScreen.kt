package ua.vmartyniuk.top100albums.feature.albums

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AlbumsScreen(
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(onClick = {
        navigateToDetails("")
    }) {
        Text(text = "Details")
    }
}