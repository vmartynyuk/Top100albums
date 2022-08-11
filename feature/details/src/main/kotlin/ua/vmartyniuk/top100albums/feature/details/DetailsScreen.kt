package ua.vmartyniuk.top100albums.feature.details

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ua.vmartyniuk.top100albums.core.common.ofPattern
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.ui.common.AppUiState
import ua.vmartyniuk.top100albums.core.ui.components.AppFilledButton
import ua.vmartyniuk.top100albums.core.ui.components.ChipsList
import ua.vmartyniuk.top100albums.core.ui.icon.AppIcon
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors
import ua.vmartyniuk.top100albums.core.ui.theme.Top100AlbumsTheme
import ua.vmartyniuk.top100albums.feature.details.fake.DetailsFakeData
import java.util.*

@Composable
fun DetailsRoute(
    onBackClick: () -> Unit,
    onVisitAlbumClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.statusBarDarkContentEnabled = false

    val albumState by viewModel.album.collectAsState()

    DetailsScreen(
        albumState = albumState,
        onBackClick = onBackClick,
        onVisitAlbumClick = onVisitAlbumClick,
        modifier = modifier
    )
}

@Composable
internal fun DetailsScreen(
    albumState: AppUiState<AlbumModel>,
    onBackClick: () -> Unit,
    onVisitAlbumClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    when (albumState) {
        AppUiState.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
        is AppUiState.Success -> {
            val year = Calendar.getInstance().get(Calendar.YEAR)
            val album = albumState.data

            val configuration = LocalConfiguration.current
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                Column(modifier = modifier.fillMaxSize()) {
                    Header(
                        album = album,
                        onBackClick = onBackClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    )
                    ContentColumnPortrait(
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 16.dp)
                    ) {
                        Content(
                            album = album,
                            year = year,
                            onVisitAlbumClick = onVisitAlbumClick
                        )
                    }
                }
            } else {
                Row(modifier = modifier.fillMaxSize()) {
                    Header(
                        album = album,
                        onBackClick = onBackClick,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    )
                    ContentColumnLandscape(
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 16.dp)
                    ) {
                        Content(
                            album = album,
                            year = year,
                            onVisitAlbumClick = onVisitAlbumClick,
                        )
                    }
                }
            }
        }
    }
}

@Composable
internal fun Header(
    album: AlbumModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = album.largeImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth(),
        )
        Column {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
            DetailsToolbar(onBackClick)
        }
    }
}

@Composable
internal fun ContentColumnPortrait(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        content()
        Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
    }
}

@Composable
internal fun ContentColumnLandscape(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        content()
        Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
    }
}

@Composable
internal fun Content(
    album: AlbumModel,
    year: Int,
    onVisitAlbumClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = album.artist,
            color = AppColors.Gray_,
            style = MaterialTheme.typography.body1
        )
        Text(
            text = album.name,
            style = MaterialTheme.typography.h1
        )
        ChipsList(album.genres, modifier = Modifier.fillMaxWidth())
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            album.releaseDate?.let { date ->
                Text(
                    text = stringResource(R.string.released_date_format, date.ofPattern("MMM dd, yyyy")),
                    color = AppColors.Gray,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                )
            }
            Text(
                text = stringResource(R.string.copiright_format, year),
                color = AppColors.Gray,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.caption,
            )
            Spacer(modifier = Modifier.height(24.dp))
            AppFilledButton(
                text = stringResource(R.string.visit_the_album),
                onClick = {
                    onVisitAlbumClick(album.url)
                },
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
internal fun DetailsToolbar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier
                .background(color = AppColors.White50, shape = CircleShape)
                .then(Modifier.size(32.dp))
        ) {
            Icon(
                painter = painterResource(id = AppIcon.BackIcon),
                contentDescription = null,
            )
        }
    }
}

@Preview(name = "portrait", showBackground = true, widthDp = 360, heightDp = 720)
@Preview(name = "landscape", showBackground = true, widthDp = 720, heightDp = 360)
@Composable
fun DetailsScreenPreview() {
    Top100AlbumsTheme {
        DetailsScreen(
            albumState = AppUiState.Success(DetailsFakeData.albumDetails),
            onBackClick = {},
            onVisitAlbumClick = {}
        )
    }
}

@Preview(name = "loading", showBackground = true, widthDp = 360, heightDp = 720)
@Composable
fun DetailsLoadingScreenPreview() {
    Top100AlbumsTheme {
        DetailsScreen(
            albumState = AppUiState.Loading,
            onBackClick = {},
            onVisitAlbumClick = {}
        )
    }
}
