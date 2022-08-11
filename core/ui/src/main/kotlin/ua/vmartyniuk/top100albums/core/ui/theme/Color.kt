package ua.vmartyniuk.top100albums.core.ui.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object AppColors {
    val White = Color.White
    val White50 = Color(0x80FFFFFF)
    val White90 = Color(0xE6FFFFFF)
    val Gray = Color(0xFFB5B5B5)
    val Gray_ = Color(0xFF8E8E93)
    val DarkGray = Color(0xFF111226)
    val Black = Color.Black
    val Black75 = Color(0xC0000000)
    val Blue = Color(0xFF007AFF)
    val Transparent = Color.Transparent
}

internal val Top100AlbumsLightColors = lightColors(
    primary = AppColors.Blue,
    onPrimary = AppColors.White,

)