package com.jquiroga.mymovie.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import com.jquiroga.mymovie.R
import com.jquiroga.mymovie.model.MediaItem
import com.jquiroga.mymovie.model.getMedia

//@Preview
@Composable
fun MediaList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_weidth)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaListItem(item, Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.cell_thumb_height))
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = item.thumb,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == MediaItem.Type.VIDEO) {
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}