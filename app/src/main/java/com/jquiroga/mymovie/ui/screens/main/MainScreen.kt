package com.jquiroga.mymovie.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jquiroga.mymovie.model.MediaItem
import com.jquiroga.mymovie.ui.MyMoviesApp

@Composable
fun MainScreen(onMediaClick: (MediaItem) -> Unit) {
    MyMoviesApp {
        Scaffold(
            topBar = {
                MainAppBar()
            }
        ) { padding ->
            MediaList(
                onMediaClick = onMediaClick,
                modifier = Modifier.padding(padding)
            )
        }
    }
}