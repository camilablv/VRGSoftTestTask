package com.ca.vrgsofttesttask.presentation.screens.topposts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ca.vrgsofttesttask.domain.model.Post
import com.ca.vrgsofttesttask.presentation.components.TopPostCard

@Composable
fun TopPostsScreen(
    
) {
    val posts = listOf<Post>(
        Post(0, "Author 1", 5L, "https://a.thumbs.redditmedia.com/AdQDIe008O1Ikjc9el2m6aQVS808rs4jFgvlHy5j100.jpg", 76),
        Post(0, "Author 2", 5L, "https://a.thumbs.redditmedia.com/AdQDIe008O1Ikjc9el2m6aQVS808rs4jFgvlHy5j100.jpg", 334),
        Post(0, "Author 3", 5L, "https://a.thumbs.redditmedia.com/AdQDIe008O1Ikjc9el2m6aQVS808rs4jFgvlHy5j100.jpg", 8),
    )
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts.size) {
            TopPostCard(post = posts[it])
        }
    }
}