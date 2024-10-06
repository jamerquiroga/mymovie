package com.jquiroga.mymovie


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jquiroga.mymovie.ui.screens.main.MainScreen
import com.jquiroga.mymovie.ui.screens.detail.DetailScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(navController)
                }
                //if argument is nullable use detail?mediaId={mediaId}
                composable(
                    route = "detail/{mediaId}",
                    arguments = listOf(
                        navArgument("mediaId") { type = NavType.IntType}
                    )
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("mediaId")
                    requireNotNull(id) {
                        "this value cannot be null"
                    }
                    DetailScreen(mediaId = id)
                }
            }
        }
    }
}
