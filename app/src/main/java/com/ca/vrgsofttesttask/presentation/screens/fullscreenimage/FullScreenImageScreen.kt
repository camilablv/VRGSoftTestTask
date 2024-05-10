package com.ca.vrgsofttesttask.presentation.screens.fullscreenimage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ca.vrgsofttesttask.R
import com.ca.vrgsofttesttask.presentation.components.IconButton

@Composable
fun FullScreenImageScreen(
    imageUrl: String,
    onCloseButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(
            id = R.drawable.cancel,
            color = Color.Gray,
            onClick = onCloseButtonClick
        )

        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            clipToBounds = true
        )
    }
}