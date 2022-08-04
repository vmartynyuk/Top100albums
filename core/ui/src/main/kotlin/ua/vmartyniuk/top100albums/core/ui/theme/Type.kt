package ua.vmartyniuk.top100albums.core.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ua.vmartyniuk.top100albums.core.ui.R

val SFProDisplay = FontFamily(
    Font(R.font.free_net_sfpro_display_regular),
    Font(R.font.free_net_sfpro_display_bold, FontWeight.Bold),
)

internal val Top100AlbumsTypography = Typography(
    defaultFontFamily = SFProDisplay,
    h6 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        letterSpacing = (-1.36).sp
    ),
)