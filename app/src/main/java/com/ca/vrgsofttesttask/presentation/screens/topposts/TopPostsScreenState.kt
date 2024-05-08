package com.ca.vrgsofttesttask.presentation.screens.topposts

import com.ca.vrgsofttesttask.domain.model.Post

data class TopPostsScreenState(
    val posts: List<Post> = listOf()
)
