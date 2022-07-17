package com.example.tmdb_client.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_client.data.models.movie.Movie

@Dao
interface MoviesDao {

    @Query("SELECT * FROM popular_movies")
    suspend fun getMoviesList(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMoviesList(moviesList: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteMoviesList()

}