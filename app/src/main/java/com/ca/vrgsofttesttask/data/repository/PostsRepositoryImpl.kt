package com.ca.vrgsofttesttask.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ca.vrgsofttesttask.data.network.ApiClient
import com.ca.vrgsofttesttask.data.paging.TopPostsPagingSource
import com.ca.vrgsofttesttask.domain.model.Post
import com.ca.vrgsofttesttask.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : PostsRepository {

    override suspend fun posts(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = { TopPostsPagingSource(apiClient) }
        ).flow
    }
}