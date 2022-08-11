package ua.vmartyniuk.top100albums.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun Top100AlbumsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = Top100AlbumsLightColors,
        typography = Top100AlbumsTypography,
        shapes = Top100AlbumsShapes,
        content = content
    )
}