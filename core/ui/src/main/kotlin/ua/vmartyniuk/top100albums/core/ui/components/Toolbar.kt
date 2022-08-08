package ua.vmartyniuk.top100albums.core.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors
import kotlin.math.ceil

@Composable
fun Toolbar(title: String, state: LazyGridState, columns: Int) {

    val rowIndex: Int = if (state.firstVisibleItemIndex == 0) 1 else {
        ceil(((state.firstVisibleItemIndex + 1f) / columns).toDouble()).toInt()
    }
    val offset = state.firstVisibleItemScrollOffset * rowIndex
    val titleMargin = with(LocalDensity.current) { offset.toDp() }

    val showLargeTitle = titleMargin < 60.dp && rowIndex == 1

    Column(
        modifier = Modifier
        .shadow(elevation = if (showLargeTitle) 0.dp else AppBarDefaults.TopAppBarElevation)
    ) {
        Column(
            modifier = Modifier
                .background(color = AppColors.White90),
        ) {
            Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .padding(horizontal = 16.dp)
            ) {
                if (!showLargeTitle) {
                    Text(
                        text = title,
                        color = AppColors.DarkGray,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
        if (showLargeTitle) {
            Text(
                text = title,
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(65.dp)
                    .offset(y = -titleMargin)
            )
        }
    }

}