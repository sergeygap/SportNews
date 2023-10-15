package com.gap.sportnews.data.network.model

import com.google.gson.annotations.SerializedName;

data class NewsDto(
    val id: Int,
    val title: String,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("social_image")
    val socialImage: String = "https://photobooth.cdn.sports.ru/preset/news/0/26/330fd1e1244d39f7545da0057004f.jpeg",
    @SerializedName("posted_time")
    val postedTime: Long,
    val content: String
)
