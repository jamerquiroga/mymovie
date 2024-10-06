package com.jquiroga.mymovie.ui.screens.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import com.jquiroga.mymovie.R
import com.jquiroga.mymovie.model.MediaItem

@Composable
fun Thumb(mediaItem: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(dimensionResource(id = R.dimen.cell_thumb_height))
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = mediaItem.thumb,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (mediaItem.type == MediaItem.Type.VIDEO) {
            Icon(
                imageVector = Icons.Default.PlayCircle,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.cell_play_icon_size))
                    .align(Alignment.Center)
            )
        }
    }
}