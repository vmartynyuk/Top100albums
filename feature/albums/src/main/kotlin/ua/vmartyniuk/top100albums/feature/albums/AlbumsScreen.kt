package ua.vmartyniuk.top100albums.feature.albums

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.ui.common.AppUiState
import ua.vmartyniuk.top100albums.core.ui.components.Toolbar
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

@Composable
fun AlbumsRoute(
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AlbumsViewModel = hiltViewModel()
) {
    val albumsState by viewModel.albums.collectAsState()
    AlbumsScreen(
        navigateToDetails,
        modifier,
        albumsState = albumsState
    )
}

@Composable
internal fun AlbumsScreen(
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
    albumsState: AppUiState<List<AlbumModel>>
) {
    val configuration = LocalConfiguration.current
    val columns = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 2

    // Todo: move hardcoded values to constants
    val topPadding = 65.dp + 42.dp + with(LocalDensity.current) {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    val bottomPadding = 12.dp + with(LocalDensity.current) {
        WindowInsets.navigationBars.getBottom(this).toDp()
    }
    val lazyGridState = rememberLazyGridState()

    Box {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = topPadding,
                bottom = bottomPadding
            ),
            state = lazyGridState,
            modifier = modifier
        ) {
            when (albumsState) {
                AppUiState.Loading -> {
                    item {
                        CircularProgressIndicator()
                    }
                }
                is AppUiState.Success<List<AlbumModel>> -> {
                    items(albumsState.data) { album ->
                        AlbumItem(
                            album,
                            onClick = { navigateToDetails(album.id) },
                            modifier = Modifier.aspectRatio(1f)
                        )
                    }
                }
            }
        }
        Toolbar(title = "Top 100 Albums", lazyGridState, columns)
    }
}