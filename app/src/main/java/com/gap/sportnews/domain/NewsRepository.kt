package com.gap.sportnews.domain


interface NewsRepository {
   suspend fun getNewsDetails(id: Int): News
   suspend fun getListNews(): List<News>
//    fun putFavorites(news: News)
//    fun getListFavorites()
//    fun deleteFavorites(id: Int)
//    fun deleteAllFavorites()
}