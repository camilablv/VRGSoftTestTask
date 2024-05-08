package com.ca.vrgsofttesttask.data.network

import com.ca.vrgsofttesttask.domain.model.TopPostsResponse
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.reddit.com"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApiClient(): ApiClient {
        val retrofit =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory())
            .build()

        return retrofit.create(ApiClient::class.java)
    }

    private fun converterFactory(): GsonConverterFactory {
        val gson = GsonBuilder()
            .registerTypeAdapter(TopPostsResponse::class.java, TopPostsResponseDeserializer())
            .create()

        return GsonConverterFactory.create(gson)
    }
}

