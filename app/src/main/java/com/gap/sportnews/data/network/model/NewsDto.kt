package com.gap.sportnews.data.network.model

data class NewsDto(
    val id: Int,
    val title: String,
    val comment_count: Int,
    val social_image: String,
    val posted_time: Int,
    val content: String
)
