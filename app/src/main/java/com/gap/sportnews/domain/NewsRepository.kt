package com.gap.sportnews.domain

interface NewsRepository {
    fun getNews(id: Int): News
    fun getListNews(): List<News>
}