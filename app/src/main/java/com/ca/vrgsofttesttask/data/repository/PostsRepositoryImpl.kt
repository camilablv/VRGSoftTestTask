package com.ca.vrgsofttesttask.data.repository

import com.ca.vrgsofttesttask.data.network.ApiClient
import com.ca.vrgsofttesttask.domain.model.Post
import com.ca.vrgsofttesttask.domain.repository.PostsRepository
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : PostsRepository {

    override suspend fun posts(): List<Post> = apiClient.topPosts().posts
}