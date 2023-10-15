package com.gap.sportnews.domain


interface NewsRepository {
   suspend fun getNewsDetails(id: Int): News
   suspend fun getListNews(from: Int, count: Int ): List<News>
//    fun putFavorites(news: News)
//    fun getListFavorites()
//    fun deleteFavorites(id: Int)
//    fun deleteAllFavorites()
}