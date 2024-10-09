package com.jquiroga.mymovie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jquiroga.mymovie.ui.screens.detail.DetailScreen
import com.jquiroga.mymovie.ui.screens.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(NavItem.Main) {
            MainScreen { mediaItem ->
                navController.navigate(NavItem.Detail.createNavRoute(mediaItem.id))
            }
        }
        //if argument is nullable use detail?mediaId={mediaId}
        composable(NavItem.Detail) { backStackEntry ->
            DetailScreen(
                mediaId = backStackEntry.findArg(NavArg.MediaId),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.getInt(arg.key)
    requireNotNull(value)
    return value as T
}