package com.ca.vrgsofttesttask.data.network

import com.ca.vrgsofttesttask.domain.model.Post
import com.ca.vrgsofttesttask.domain.model.TopPostsResponse
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class TopPostsResponseDeserializer: JsonDeserializer<TopPostsResponse> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): TopPostsResponse {
        val gson = Gson()

        val posts = json
            ?.asJsonObject?.get("data")
            ?.asJsonObject?.get("children")
            ?.asJsonArray?.map {
                val child = it.asJsonObject?.get("data")
                gson.fromJson(child, Post::class.java)
            }

        return TopPostsResponse(posts ?: emptyList())
    }
}