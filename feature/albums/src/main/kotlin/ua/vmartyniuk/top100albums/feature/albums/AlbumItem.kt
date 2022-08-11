package ua.vmartyniuk.top100albums.feature.albums

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.ui.theme.AppColors
import ua.vmartyniuk.top100albums.core.ui.theme.Top100AlbumsTheme
import ua.vmartyniuk.top100albums.feature.albums.fake.AlbumsFakeData

@Composable
fun AlbumItem(
    album: AlbumModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card {
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = modifier,
        ) {
            AsyncImage(
                model = album.smallImageUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .fillMaxSize()
                    .clickable { onClick() },
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                AppColors.Transparent,
                                AppColors.Black75
                            )
                        )
                    )
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = album.name,
                    color = AppColors.White,
                    maxLines = 2,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = album.artist,
                    color = AppColors.Gray,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}

@Preview
@Composable
fun previewCard() {
    AlbumItem(
        album = AlbumsFakeData.albums[0],
        onClick = {},
        modifier = Modifier.size(200.dp)
    )
}