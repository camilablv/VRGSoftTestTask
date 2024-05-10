package com.ca.vrgsofttesttask.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ca.vrgsofttesttask.R

@Composable
fun CommentCountText(count: Int) {
    Row(
        modifier = Modifier
            .background(Color.Gray, RoundedCornerShape(8.dp))
            .width(68.dp)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.chatbubble),
            contentDescription = null,
            tint = Color.White
        )

        Text(
            text = count.toString(),
            color = Color.White,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
        )
    }
}