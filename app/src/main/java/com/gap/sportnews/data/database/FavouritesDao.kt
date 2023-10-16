package com.gap.sportnews.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites")
    suspend fun getListFavourites(): List<FavouritesDbModel>
    @Query("SELECT EXISTS (SELECT 1 FROM favourites WHERE id = :id) != 0")
    suspend fun getFavouriteById(id: Long): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavourites(favourites: FavouritesDbModel)

    @Delete
    suspend fun deleteFavourites(favourites: FavouritesDbModel)

    @Query("DELETE FROM favourites")
    suspend fun deleteAllFavourites()
}