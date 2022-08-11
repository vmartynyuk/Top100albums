package ua.vmartyniuk.top100albums.core.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppFilledButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    colors: ButtonColors = AppButtonDefaults.filledButtonColors(),
    contentPadding: PaddingValues = AppButtonDefaults.buttonContentPadding()
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = colors,
        modifier = modifier
    ) {
        Text(text = text, style = MaterialTheme.typography.button)
    }
}

object AppButtonDefaults {
    const val DisabledButtonContainerAlpha = 0.12f
    val ButtonHorizontalPadding = 20.dp
    val ButtonVerticalPadding = 12.dp

    @Composable
    fun filledButtonColors(
        backgroundColor: Color = MaterialTheme.colors.primary,
        contentColor: Color = MaterialTheme.colors.onPrimary,
        disabledBackgroundColor: Color = MaterialTheme.colors.primary.copy(
            alpha = DisabledButtonContainerAlpha
        ),
        disabledContentColor: Color = MaterialTheme.colors.onPrimary.copy(
            alpha = DisabledButtonContainerAlpha
        )
    ) = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )

    fun buttonContentPadding(): PaddingValues {
        return PaddingValues(
            horizontal = ButtonHorizontalPadding,
            vertical = ButtonVerticalPadding,
        )
    }
}