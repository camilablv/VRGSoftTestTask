package com.ca.vrgsofttesttask.domain.model

data class Post(
    val author: String,
    val created: Long,
    val imageThumbnail: String? = null,
    val imageUrl: String,
    val commentCount: Int
)
