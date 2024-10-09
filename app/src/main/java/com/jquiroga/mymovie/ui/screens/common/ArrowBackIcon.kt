package com.jquiroga.mymovie.ui.screens.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun ArrowBackIcon(onUpClick: () -> Unit) {
    IconButton(onClick = onUpClick) {
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = "Go to previous screen"
        )
    }
}