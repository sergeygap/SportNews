package com.gap.sportnews.data.database

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity(tableName = "news_info")
data class NewsDbModel(
    val id: Int,
    val title: String,
    @SerializedName("comment_count") val commentCount: Int,
    @SerializedName("social_image") val socialImage: String,
    @SerializedName("posted_time") val postedTime: Long,
    val content: String
)
