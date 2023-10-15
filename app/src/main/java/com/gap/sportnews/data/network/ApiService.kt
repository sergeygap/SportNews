package com.gap.sportnews.data.network

import com.gap.sportnews.data.network.model.NewsDto
import com.gap.sportnews.data.network.model.NewsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("news.json?category_id=208")
    suspend fun getListNews(
        @Query(FROM) from: Int,
        @Query(COUNT) count: Int
    ): NewsListDto
    @GET("news_item.json")
    suspend fun getNewsDetails(
        @Query(ID) id: Int
    ): NewsDto

    companion object {
        private const val ID = "id"
        private const val COUNT = "count"
        private const val FROM = "from"
    }
}