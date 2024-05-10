package com.ca.vrgsofttesttask.domain.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("author") val author: String,
    @SerializedName("created") val created: Long,
    @SerializedName("thumbnail") val imageThumbnail: String? = null,
    @SerializedName("url") val imageUrl: String,
    @SerializedName("num_comments") val commentCount: Int
)
