package com.ca.vrgsofttesttask.presentation.screens.fullscreenimage

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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
    val contentScale = if (LocalConfiguration.current.screenWidthDp >= 600) ContentScale.FillHeight
        else ContentScale.FillWidth

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
                .error(R.drawable.error)
                .listener(
                    onSuccess = {req, result ->
                        Log.d("IMAGE REQUEST", "$req, $result")
                    }, onError = {req, result ->
                        Log.d("IMAGE REQUEST", "$req, $result")
                    }
                )
                .build(),
            contentDescription = null,
            contentScale = contentScale,
            clipToBounds = true
        )
    }
}