package com.ca.vrgsofttesttask.data.network

import com.ca.vrgsofttesttask.domain.model.TopPostsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/top.json")
    suspend fun topPosts(@Query("after") after: String?): TopPostsResponse
}