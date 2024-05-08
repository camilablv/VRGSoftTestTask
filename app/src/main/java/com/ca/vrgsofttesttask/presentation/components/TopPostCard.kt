package com.ca.vrgsofttesttask.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ca.vrgsofttesttask.domain.model.Post

@Composable
fun TopPostCard(
    post: Post
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Row {
                    Text(text = post.author)
                    Text(text = post.created.toString())
                }

                Text(text = post.commentCount.toString())
            }

            post.thumbnail?.let {
                AsyncImage(
                    model = it,
                    contentDescription = null
                )
            }
        }
    }
}