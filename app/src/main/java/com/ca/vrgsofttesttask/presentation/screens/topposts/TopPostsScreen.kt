package com.ca.vrgsofttesttask.presentation.screens.topposts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.ca.vrgsofttesttask.data.ImageDownloader
import com.ca.vrgsofttesttask.presentation.components.TopPostCard

@Composable
fun TopPostsScreen(
    viewModel: PostsViewModel = hiltViewModel(),
    navigateToFullScreenImage: (String) -> Unit
) {

    val listState = rememberLazyListState()

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val posts = viewState.value.posts.collectAsLazyPagingItems()
    val context = LocalContext.current


    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = listState
    ) {
        items(posts.itemCount) { index ->
            posts[index]?.let { post ->
                TopPostCard(
                    post = post,
                    onThumbnailClick = {
                        navigateToFullScreenImage(post.imageUrl)
                    },
                    onDownloadClick = {
                        ImageDownloader(context).downloadImage(it)
                    }
                )
            }
        }
    }
}
