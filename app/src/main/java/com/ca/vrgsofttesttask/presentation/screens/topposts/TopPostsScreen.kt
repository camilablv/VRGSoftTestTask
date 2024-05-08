package com.ca.vrgsofttesttask.presentation.screens.topposts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ca.vrgsofttesttask.presentation.components.TopPostCard

@Composable
fun TopPostsScreen(
    viewModel: PostsViewModel = hiltViewModel()
) {

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(viewState.value.posts.size) {
            TopPostCard(post = viewState.value.posts[it])
        }
    }
}