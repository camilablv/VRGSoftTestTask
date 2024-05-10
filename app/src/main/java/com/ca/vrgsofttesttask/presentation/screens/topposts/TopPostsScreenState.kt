package com.ca.vrgsofttesttask.presentation.screens.topposts

import androidx.paging.PagingData
import com.ca.vrgsofttesttask.domain.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class TopPostsScreenState(
    val posts: Flow<PagingData<Post>> = flowOf()
)
