package com.gap.sportnews.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gap.sportnews.domain.Favourites

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites")
    fun getListFavourites(): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavourites(favourites: FavouritesDbModel)

    @Delete
    suspend fun deleteFavourites(favourites: FavouritesDbModel)

    @Query("DELETE FROM favourites")
    suspend fun deleteAllFavourites()
}