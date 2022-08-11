package ua.vmartyniuk.top100albums.core.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import ua.vmartyniuk.top100albums.core.ui.theme.SFProText

@Composable
fun ChipsList(chips: List<String>, modifier: Modifier = Modifier) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
        modifier = modifier
    ) {
        chips.forEach { genre ->
            Chip(text = genre)
        }
    }
}

@Composable
fun Chip(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = MaterialTheme.colors.primary,
            fontFamily = SFProText,
            fontWeight = FontWeight.Medium,
        ),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
    )
}

@Preview
@Composable
fun ChipPreview() {
    Chip(text = "Chip")
}

@Preview
@Composable
fun ChipListPreview() {
    ChipsList(listOf(
        "Chip 1", "Chip 2", "Chip 3"
    ))
}