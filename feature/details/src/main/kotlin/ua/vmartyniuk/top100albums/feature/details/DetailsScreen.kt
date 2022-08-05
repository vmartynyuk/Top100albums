package ua.vmartyniuk.top100albums.feature.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(text = "Details")
}