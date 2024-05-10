package com.ca.vrgsofttesttask.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun IconButton(
    @DrawableRes id: Int,
    color: Color = Color.White,
    onClick: () -> Unit,
) {
    androidx.compose.material3.IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id),
            contentDescription = null,
            tint = color
        )
    }
}