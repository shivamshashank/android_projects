package com.example.tmdb_client.data.repository.movie.data_source

import com.example.tmdb_client.data.models.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(moviesList: List<Movie>)
    suspend fun clearAll()
}