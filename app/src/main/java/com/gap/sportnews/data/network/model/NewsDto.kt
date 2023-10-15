package com.gap.sportnews.data.network.model

import com.google.gson.annotations.SerializedName;

data class NewsDto(
    val id: Int,
    val title: String,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("social_image")
    val socialImage: String,
    @SerializedName("posted_time")
    val postedTime: Long,
    val content: String
)
