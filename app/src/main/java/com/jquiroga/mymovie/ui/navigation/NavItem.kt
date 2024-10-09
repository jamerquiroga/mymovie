package com.jquiroga.mymovie.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    val navArgs: List<NavArg> = emptyList()
) {
    val route = run {
        val argsKey = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argsKey)
            .joinToString ( "/" )
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

    data object Main : NavItem("main")
    data object Detail : NavItem("detail", listOf(NavArg.MediaId)) {
        fun createNavRoute(mediaId: Int) = "$baseRoute/$mediaId"
    }
}

enum class NavArg(val key: String, val navType: NavType<*>) {
    MediaId("mediaId", NavType.IntType)
}