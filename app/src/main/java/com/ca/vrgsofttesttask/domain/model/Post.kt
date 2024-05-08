package com.ca.vrgsofttesttask.domain.model

data class Post(
    val id: Int,
    val author: String,
    val created: Long,
    val thumbnail: String? = null,
    val commentCount: Int
)
