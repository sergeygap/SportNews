package com.gap.sportnews.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.map
import com.gap.sportnews.data.database.AppDatabase
import com.gap.sportnews.data.database.FavouritesDbModel
import com.gap.sportnews.data.mapper.Mapper
import com.gap.sportnews.data.network.ApiFactory
import com.gap.sportnews.domain.Favourites
import com.gap.sportnews.domain.News
import com.gap.sportnews.domain.NewsRepository

class NewsRepositoryImpl(
    application: Application
) : NewsRepository {
    private val favouritesDao = AppDatabase.getInstance(application).favouritesDao()
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

    override suspend fun addFavorites(id: Long) {
        favouritesDao.addFavourites(FavouritesDbModel(id))
    }

    override suspend fun getListFavorites(): List<Favourites> {
        return favouritesDao.getListFavourites().map {
            mapper.mapFavouritesDbModelToFavourites(it)
        }
    }

    override suspend fun deleteFavorites(id: Long) {
        favouritesDao.deleteFavourites(FavouritesDbModel(id))
    }

    override suspend fun deleteAllFavorites() {
        favouritesDao.deleteAllFavourites()
    }

    override suspend fun checkId(id: Int): Boolean {
        return favouritesDao.getFavouriteById(id.toLong())
    }
}