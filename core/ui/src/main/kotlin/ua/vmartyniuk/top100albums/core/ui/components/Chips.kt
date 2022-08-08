package ua.vmartyniuk.top100albums.core.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors
import ua.vmartyniuk.top100albums.core.ui.theme.SFProText

@Composable
fun ChipsList(text: List<String>) {
    Row {
        text.forEachIndexed { index, genre ->
            Chip(text = genre)
            if ((index + 1) < text.size) {
                Spacer(Modifier.width(5.0.dp))
            }
        }
    }
}

@Composable
fun Chip(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = AppColors.Blue,
            fontFamily = SFProText,
            fontWeight = FontWeight.Medium,
        ),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = AppColors.Blue,
                shape = RoundedCornerShape(20.dp)
            ).padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
    )
}