package com.gap.sportnews.domain

data class News(
    val id: Int,
    val title: String,
    val commentCount: Int,
    val socialImage: String,
    val postedTime: Long,
    val content: String
)
