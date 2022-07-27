package com.example.tmdb_client.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_client.data.models.tv_shows.TvShow

@Dao
interface TvShowsDao {

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShowsList(): List<TvShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShowsList(tvShowsList: List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteTvShowsList()

}