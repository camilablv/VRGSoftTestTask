package com.ca.vrgsofttesttask.data.network

import com.ca.vrgsofttesttask.domain.model.TopPostsResponse
import retrofit2.http.GET

interface ApiClient {

    @GET("/top.json")
    suspend fun topPosts(): TopPostsResponse
}