package ua.vmartyniuk.top100albums.feature.albums.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.navigation.Top100AlbumsNavigationDestination
import ua.vmartyniuk.top100albums.feature.albums.AlbumsRoute

object AlbumsDestination : Top100AlbumsNavigationDestination {
    override val route = "albums_route"
    override val destination = "albums_destination"
}

fun NavGraphBuilder.albumsGraph(
    navigateToDetails: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    composable(route = AlbumsDestination.route) {
        AlbumsRoute(navigateToDetails)
    }
    nestedGraphs()
}