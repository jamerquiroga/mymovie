package com.jquiroga.mymovie.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.jquiroga.mymovie.ui.theme.MyMovieTheme

@Composable
fun MyMoviesApp(content: @Composable () -> Unit) {
    MyMovieTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}