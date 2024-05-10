package com.ca.vrgsofttesttask.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ca.vrgsofttesttask.data.model.toPost
import com.ca.vrgsofttesttask.data.network.ApiClient
import com.ca.vrgsofttesttask.domain.model.Post
import javax.inject.Inject

class TopPostsPagingSource @Inject constructor(
    private val apiClient: ApiClient
) : PagingSource<String, Post>() {
    override fun getRefreshKey(state: PagingState<String, Post>): String? {
        return state.pages.last().nextKey
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Post> {
        val result = apiClient.topPosts(params.key)
        return LoadResult.Page(
            data = result.posts.map { it.toPost() },
            prevKey = result.before,
            nextKey = result.after
        )
    }
}