package ua.vmartyniuk.top100albums.feature.albums

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.ui.common.AppUiState
import ua.vmartyniuk.top100albums.core.ui.components.Toolbar
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors
import ua.vmartyniuk.top100albums.core.ui.theme.Top100AlbumsTheme
import ua.vmartyniuk.top100albums.feature.albums.fake.AlbumsFakeData
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

@Composable
fun AlbumsRoute(
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AlbumsViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.statusBarDarkContentEnabled = true

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

    val appBarHeight = 42.dp
    val titleHeight = 65.dp
    val bottomSpace = 12.dp

    val topPadding = titleHeight + appBarHeight + with(LocalDensity.current) {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    val bottomPadding = bottomSpace + with(LocalDensity.current) {
        WindowInsets.navigationBars.getBottom(this).toDp()
    }
    val lazyGridState = rememberLazyGridState()

    Box {
        when (albumsState) {
            AppUiState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
            is AppUiState.Success<List<AlbumModel>> -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(columns),
                    state = lazyGridState,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        end = 16.dp,
                        top = topPadding,
                        bottom = bottomPadding
                    ),
                    modifier = modifier.fillMaxSize()
                ) {
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
        Toolbar(title = stringResource(R.string.app_title), lazyGridState, columns)
    }
}

@Preview(name = "portrait", showBackground = true, widthDp = 360, heightDp = 720)
@Preview(name = "landscape", showBackground = true, widthDp = 720, heightDp = 360)
@Composable
fun DetailsScreenPreview() {
    Top100AlbumsTheme {
        AlbumsScreen(
            navigateToDetails = {},
            albumsState = AppUiState.Success(AlbumsFakeData.albums),
        )
    }
}

@Preview(name = "loading", showBackground = true, widthDp = 360, heightDp = 720)
@Composable
fun DetailsLoadingScreenPreview() {
    Top100AlbumsTheme {
        AlbumsScreen(
            navigateToDetails = {},
            albumsState = AppUiState.Loading,
        )
    }
}