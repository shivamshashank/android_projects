package com.example.tmdb_client.domain.repository

import com.example.tmdb_client.data.models.movie.Movie

interface MovieRepository {

    suspend fun getMoviesList(): List<Movie>?
    suspend fun updateMoviesList(): List<Movie>?

}