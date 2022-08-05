package ua.vmartyniuk.top100albums.navigation

import ua.vmartyniuk.top100albums.core.navigation.Top100AlbumsNavigationDestination

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
): Top100AlbumsNavigationDestination