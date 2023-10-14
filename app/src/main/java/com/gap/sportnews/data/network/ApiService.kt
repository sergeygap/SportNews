package com.gap.sportnews.data.network

import com.gap.sportnews.data.network.model.NewsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("news.json?category_id=208&from=0&count=10")
    suspend fun getListNews(): List<NewsDto>
    @GET("news_item.json")
    suspend fun getNews(
        @Query(ID) id: Int
    ): NewsDto

    companion object {
        private const val ID = "id"
    }
}