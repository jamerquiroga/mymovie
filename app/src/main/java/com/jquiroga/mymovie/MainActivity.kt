package com.jquiroga.mymovie


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jquiroga.mymovie.ui.screens.main.MainScreen
import com.jquiroga.mymovie.ui.MyMoviesApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesApp {
                MainScreen()
            }
        }
    }
}
