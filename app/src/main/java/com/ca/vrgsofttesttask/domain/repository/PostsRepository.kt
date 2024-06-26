package com.ca.vrgsofttesttask.domain.repository

import androidx.paging.PagingData
import com.ca.vrgsofttesttask.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun posts(): Flow<PagingData<Post>>
}