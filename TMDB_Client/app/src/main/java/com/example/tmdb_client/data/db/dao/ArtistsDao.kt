package com.example.tmdb_client.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_client.data.models.artist.Artist

@Dao
interface ArtistsDao {

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtistsList(): List<Artist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtistsList(artistsList: List<Artist>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteArtistsList()

}