package ua.vmartyniuk.top100albums.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import ua.vmartyniuk.top100albums.core.navigation.Top100AlbumsNavigationDestination

class Top100AlbumsNavigation(private val navController: NavHostController) {
    fun navigateTo(destination: Top100AlbumsNavigationDestination, route: String? = null) {
        if (destination is TopLevelDestination) {
            navController.navigate(route ?: destination.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        } else {
            navController.navigate(route ?: destination.route)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}