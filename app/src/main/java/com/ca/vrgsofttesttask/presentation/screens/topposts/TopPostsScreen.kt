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
    val posts = listOf<Post>()
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts.size) {
            posts[it].let { post -> 
                TopPostCard(post = post)
            }
        }
    }
}