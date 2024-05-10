package com.ca.vrgsofttesttask.data.model

data class TopPostsResponse(
    val before: String?,
    val posts: List<PostResponse>,
    val after: String?
)