package com.gap.sportnews.domain

import androidx.lifecycle.LiveData


interface NewsRepository {
    suspend fun getNewsDetails(id: Int): News
    suspend fun getListNews(from: Int, count: Int): List<News>
    suspend fun addFavorites(id: Long)
    suspend fun getListFavorites(): List<Favourites>
    suspend fun deleteFavorites(id: Long)
    suspend fun deleteAllFavorites()
    suspend fun checkId(id: Int): Boolean
}