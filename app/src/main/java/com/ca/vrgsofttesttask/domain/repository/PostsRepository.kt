package com.ca.vrgsofttesttask.domain.repository

import com.ca.vrgsofttesttask.domain.model.Post

interface PostsRepository {
    suspend fun posts(): List<Post>
}