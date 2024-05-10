package com.ca.vrgsofttesttask.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ca.vrgsofttesttask.R
import com.ca.vrgsofttesttask.domain.model.Post
import com.ca.vrgsofttesttask.utils.getRelativeTime

@Composable
fun TopPostCard(
    post: Post,
    onThumbnailClick: () -> Unit,
    onDownloadClick: (String) -> Unit
) {
    val isThumbnailEnabled = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = post.author,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                )

                Text(
                    text = getRelativeTime(post.created),
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                )

                CommentCountText(count = post.commentCount)
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(120.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(
                            enabled = isThumbnailEnabled.value
                        ) {
                            onThumbnailClick()
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(post.imageThumbnail)
                        .listener(
                            onSuccess = { _, _ -> isThumbnailEnabled.value = true }
                        )
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    clipToBounds = true
                )

                if (isThumbnailEnabled.value) {
                    IconButton(id = R.drawable.download) {
                        onDownloadClick(post.imageUrl)
                    }
                }
            }
        }
    }
}