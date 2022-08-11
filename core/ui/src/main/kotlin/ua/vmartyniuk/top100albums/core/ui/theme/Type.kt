package ua.vmartyniuk.top100albums.core.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ua.vmartyniuk.top100albums.core.ui.R

val SFProDisplay = FontFamily(
    Font(R.font.sfpro_display_regular),
    Font(R.font.sfpro_display_bold, FontWeight.Bold),
)

val SFProText = FontFamily(
    Font(R.font.sfpro_text_regular),
    Font(R.font.sfpro_text_bold, FontWeight.Bold),
    Font(R.font.sfpro_text_medium, FontWeight.Medium),
    Font(R.font.sfpro_text_semibold, FontWeight.SemiBold),
)

internal val Top100AlbumsTypography = Typography(
    h1 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        letterSpacing = (-0.04).sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = (0.01).sp,
    ),
    body1 = TextStyle(
        fontFamily = SFProText,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = (-0.04).sp,
    ),
    body2 = TextStyle(
        fontFamily = SFProText,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = (-0.04).sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = (-0.04).sp,
    ),
    button = TextStyle(
        fontFamily = SFProText,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = (-0.04).sp,
    ),
    caption = TextStyle(
        fontFamily = SFProText,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
)