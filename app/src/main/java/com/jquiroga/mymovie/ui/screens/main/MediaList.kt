package com.jquiroga.mymovie.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.jquiroga.mymovie.R
import com.jquiroga.mymovie.model.MediaItem
import com.jquiroga.mymovie.model.getMedia
import com.jquiroga.mymovie.ui.screens.common.Thumb

//@Preview
@Composable
fun MediaList(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_weidth)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaListItem(item, navController, Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaListItem(mediaItem: MediaItem, navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clickable { navController.navigate("detail/${mediaItem.id}") }
    ) {
        Thumb(mediaItem = mediaItem)
        Title(mediaItem = mediaItem)
    }
}

@Composable
private fun Title(mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}