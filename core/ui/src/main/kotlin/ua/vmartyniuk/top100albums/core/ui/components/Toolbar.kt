package ua.vmartyniuk.top100albums.core.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors

@Composable
fun Toolbar(title: String) {
    TopAppBar(
        backgroundColor = AppColors.White85
    ) {
        Text(text = title)
    }
}

@Preview
@Composable
fun ToolbarPreview() {
    Toolbar(title = "Hello world")
}