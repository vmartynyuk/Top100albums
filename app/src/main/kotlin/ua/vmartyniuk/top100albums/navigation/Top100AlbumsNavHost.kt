package ua.vmartyniuk.top100albums.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ua.vmartyniuk.top100albums.core.navigation.Top100AlbumsNavigationDestination
import ua.vmartyniuk.top100albums.feature.albums.navigation.AlbumsDestination
import ua.vmartyniuk.top100albums.feature.albums.navigation.albumsGraph
import ua.vmartyniuk.top100albums.feature.details.navigation.DetailsDestination
import ua.vmartyniuk.top100albums.feature.details.navigation.detailsGraph

@Composable
fun Top100AlbumsNavHost(
    navController: NavHostController,
    onNavigateToDestination: (Top100AlbumsNavigationDestination, String) -> Unit,
    onBackClick: () -> Unit,
    onVisitAlbumClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = AlbumsDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        albumsGraph(
            navigateToDetails = { albumId ->
                onNavigateToDestination(
                    DetailsDestination, DetailsDestination.createNavigationRoute(albumId)
                )
            },
            nestedGraphs = {
                detailsGraph(
                    onBackClick = {
                        onBackClick()
                    },
                    onVisitAlbumClick = { url ->
                        onVisitAlbumClick(url)
                    }
                )
            }
        )
    }
}