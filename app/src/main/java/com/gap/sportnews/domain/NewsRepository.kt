package com.gap.sportnews.domain

interface NewsRepository {
    fun getNewsDetails(id: Int): News
    fun getListNews(): List<News>
//    fun putFavorites(news: News)
//    fun getListFavorites()
//    fun deleteFavorites(id: Int)
//    fun deleteAllFavorites()
}