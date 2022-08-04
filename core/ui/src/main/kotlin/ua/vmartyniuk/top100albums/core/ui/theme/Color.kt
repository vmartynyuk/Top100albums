package ua.vmartyniuk.top100albums.core.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object AppColors {
    val White = Color.White
    val White85 = Color(0xD9FFFFFF)
    val DarkGray = Color(0xFF111226)
}

internal val Top100AlbumsLightColors = lightColors(
    primary = AppColors.White,
    onPrimary = AppColors.DarkGray,
)

internal val Top100AlbumsDarkColors = darkColors(
    primary = AppColors.DarkGray,
    onPrimary = AppColors.White,
)