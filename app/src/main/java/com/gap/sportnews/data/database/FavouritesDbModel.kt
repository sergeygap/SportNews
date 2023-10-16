package com.gap.sportnews.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class FavouritesDbModel(
    @PrimaryKey
    val id: Long
)
