package ua.vmartyniuk.top100albums.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ua.vmartyniuk.top100albums.core.ui.theme.Top100AlbumsTheme
import ua.vmartyniuk.top100albums.navigation.Top100AlbumsNavHost
import ua.vmartyniuk.top100albums.navigation.Top100AlbumsNavigation

@Composable
fun Top100AlbumsApp() {
    val navController = rememberNavController()
    val navigation = remember(navController) {
        Top100AlbumsNavigation(navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Top100AlbumsTheme {
        Scaffold { padding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {
                Top100AlbumsNavHost(
                    navController = navController,
                    onNavigateToDestination = { destination, route ->
                        navigation.navigateTo(destination, route)
                    },
                    onBackClick = {
                        navigation.onBackClick()
                    },
                    modifier = Modifier
                        .padding(padding)
                )
            }
        }
    }
}