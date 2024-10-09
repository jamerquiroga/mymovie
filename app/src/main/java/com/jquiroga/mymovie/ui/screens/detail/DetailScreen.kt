package com.jquiroga.mymovie.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.jquiroga.mymovie.model.getMedia
import com.jquiroga.mymovie.ui.screens.common.ArrowBackIcon
import com.jquiroga.mymovie.ui.screens.common.Thumb

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    val mediaItem = remember {
        getMedia().first() { it.id == mediaId }
    }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = {
                    ArrowBackIcon(onUpClick)
                }
            )
        }
    ) { padding ->
        Thumb(mediaItem = mediaItem, Modifier.padding(padding))
    }
}