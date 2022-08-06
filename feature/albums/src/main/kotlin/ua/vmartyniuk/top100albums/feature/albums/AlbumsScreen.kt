package ua.vmartyniuk.top100albums.feature.albums

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import kotlin.math.ceil

@Composable
fun AlbumsRoute(
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AlbumsViewModel = hiltViewModel()
) {
    val albumsState = viewModel.albums.collectAsStateWithLifecycle(initialValue = emptyList())
    AlbumsScreen(
        navigateToDetails,
        modifier,
        albumsState = albumsState
    )
}

@Composable
fun AlbumsScreen(
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
    albumsState: State<List<AlbumModel>>
) {
    var titleMargin by remember { mutableStateOf(0.dp) }
    val configuration = LocalConfiguration.current
    val columns = when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> 4
        else -> 2
    }
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        Text(
            text = "Top 100 Albums",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(
                    bottom = 12.dp,
                    start = 16.dp,
                    end = 16.dp,
                    top = 12.dp,
                )
                .offset(y = titleMargin)
        )
        Box(modifier = Modifier) {
            val lazyGridState = rememberLazyGridState()

//            if (lazyGridState.isScrollInProgress) {
//                val rowIndex: Int = if (lazyGridState.firstVisibleItemIndex == 0) 1 else {
//                    ceil(((lazyGridState.firstVisibleItemIndex + 1f) / columns).toDouble()).toInt()
//                }
//                val offset = lazyGridState.firstVisibleItemScrollOffset * rowIndex
//                titleMargin = (-offset).dp
//                Log.d("TAG", "AlbumsScreen: ${titleMargin}")
//            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(columns),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(all = 16.dp),
                modifier = modifier,
                state = lazyGridState
            ) {
                val albums: List<AlbumModel> = albumsState.value
                albums.forEach { album ->
                    item {
                        AlbumItem(
                            album,
                            onClick = { navigateToDetails(album.id) },
                            modifier = Modifier.aspectRatio(1f)
                        )
                    }
                }
            }
//            Toolbar(title = "Top 100 Albums")
        }
    }
}

//@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
//@Preview(name = "landscape", device = "spec:shape=Normal,width=640,height=360,unit=dp,dpi=480")
//@Preview(name = "foldable", device = "spec:shape=Normal,width=673,height=841,unit=dp,dpi=480")
//@Preview(name = "tablet", device = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=480")
//@Composable
//fun AlbumsScreenPopulated() {
//    Top100AlbumsTheme {
//        AlbumsScreen(navigateToDetails = {})
//    }
//}