package com.gap.sportnews.data.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface NewsDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertNewsInfo(listNews: List<NewsDbModel>)
//    @Query("SELECT * FROM news_info WHERE id = :id LIMIT 1")
//    fun getNews(id: Int): LiveData<List<NewsDbModel>>
//    @Query("SELECT * FROM news_info")
//    fun getListNews(): LiveData<List<NewsDbModel>>
}