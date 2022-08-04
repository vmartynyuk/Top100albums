package ua.vmartyniuk.top100albums.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors
import ua.vmartyniuk.top100albums.core.ui.theme.Top100AlbumsTheme

@Composable
fun Top100AlbumsApp() {
    Top100AlbumsTheme {
        Scaffold(
            topBar = { Toolbar(title = "Top 100 Albums") }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {
                Text(
                    text = "Hello world",
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun Toolbar(title: String) {
    TopAppBar(
        backgroundColor = AppColors.White85,
        title = {
            Text(text = title)
        }
    )
}