package ua.vmartyniuk.top100albums.feature.details.navigation

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ua.vmartyniuk.top100albums.core.navigation.Top100AlbumsNavigationDestination
import ua.vmartyniuk.top100albums.feature.details.DetailsRoute

object DetailsDestination : Top100AlbumsNavigationDestination {
    const val albumIdArg = "albumId"
    override val route = "details_route/{$albumIdArg}"
    override val destination = "details_destination"

    fun createNavigationRoute(albumIdArg: String): String {
        val encodedId = Uri.encode(albumIdArg)
        return "details_route/$encodedId"
    }
}

fun NavGraphBuilder.detailsGraph(
    onBackClick: () -> Unit,
    onVisitAlbumClick: (String) -> Unit,
) {
    composable(
        route = DetailsDestination.route,
        arguments = listOf(
            navArgument(DetailsDestination.albumIdArg) { type = NavType.StringType }
        )
    ) {
        DetailsRoute(
            onBackClick = onBackClick,
            onVisitAlbumClick = onVisitAlbumClick
        )
    }
}