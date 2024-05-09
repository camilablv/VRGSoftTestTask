package com.ca.vrgsofttesttask.domain.model

data class TopPostsResponse(
    val before: String?,
    val posts: List<Post>,
    val after: String?
)