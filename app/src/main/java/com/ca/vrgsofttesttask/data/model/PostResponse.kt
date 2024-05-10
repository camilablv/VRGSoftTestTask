package com.ca.vrgsofttesttask.data.model

import com.ca.vrgsofttesttask.domain.model.Post
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("author") val author: String,
    @SerializedName("created") val created: Long,
    @SerializedName("thumbnail") val imageThumbnail: String? = null,
    @SerializedName("url") val imageUrl: String,
    @SerializedName("num_comments") val commentCount: Int
)

fun PostResponse.toPost(): Post {
    return Post(
        author = this.author,
        created = this.created,
        imageThumbnail = this.imageThumbnail,
        imageUrl = this.imageUrl,
        commentCount = this.commentCount
    )
}
