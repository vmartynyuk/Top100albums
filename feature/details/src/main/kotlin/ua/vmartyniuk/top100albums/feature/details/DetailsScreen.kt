package ua.vmartyniuk.top100albums.feature.details
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ua.vmartyniuk.top100albums.core.common.ofPattern
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.ui.components.AppFilledButton
import ua.vmartyniuk.top100albums.core.ui.components.ChipsList
import ua.vmartyniuk.top100albums.core.ui.icon.AppIcon
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors
import java.util.*

@Composable
fun DetailsRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val albumState = viewModel.album.collectAsState(null)
    DetailsScreen(
        albumState = albumState,
        onBackClick = onBackClick,
        modifier = modifier
    )
}

@Composable
internal fun DetailsScreen(
    albumState: State<AlbumModel?>,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    val album: AlbumModel? = albumState.value
    val year = Calendar.getInstance().get(Calendar.YEAR)

    if (album != null) {
        Column(
            modifier = modifier
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                AsyncImage(
                    model = album.largeImageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier.fillMaxWidth(),
                )
                Column {
                    Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
                    DetailsToolbar(onBackClick)
                }
            }
            Column(
                modifier = Modifier
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
                ChipsList(album.genres)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    album.releaseDate?.let { date ->
                        Text(
                            text = "Released ${date.ofPattern("MMM dd, yyyy")}",
                            color = AppColors.Gray,
                            style = MaterialTheme.typography.caption,
                        )
                    }
                    Text(
                        text = "Copyright $year Apple Inc. All rights reserved.",
                        color = AppColors.Gray,
                        style = MaterialTheme.typography.caption,
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    AppFilledButton(
                        text = "Visit The Album",
                        onClick = {},
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
                }
            }
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
