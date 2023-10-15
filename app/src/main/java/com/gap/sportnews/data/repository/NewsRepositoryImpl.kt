package com.gap.sportnews.data.repository

import com.gap.sportnews.data.mapper.Mapper
import com.gap.sportnews.data.network.ApiFactory
import com.gap.sportnews.domain.News
import com.gap.sportnews.domain.NewsRepository

class NewsRepositoryImpl : NewsRepository {
    private val apiService = ApiFactory.apiService
    private val mapper = Mapper()

    override suspend fun getNewsDetails(id: Int): News {
        return mapper.mapDtoEntity(apiService.getNewsDetails(id))
    }

    override suspend fun getListNews(from: Int, count: Int): List<News> {
        return apiService.getListNews(from, count).news.map {
            mapper.mapDtoEntity(it)
        }
    }
}