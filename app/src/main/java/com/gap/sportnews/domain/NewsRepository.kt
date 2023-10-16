package com.gap.sportnews.domain

import androidx.lifecycle.LiveData


interface NewsRepository {
    suspend fun getNewsDetails(id: Int): News
    suspend fun getListNews(from: Int, count: Int): List<News>
    suspend fun addFavorites(id: Long)
    suspend fun getListFavorites(): List<Long>
    suspend fun deleteFavorites(id: Long)
    suspend fun deleteAllFavorites()
}