package com.example.tmdb_client.data.repository.movie.data_source

import com.example.tmdb_client.data.models.movie.MoviesList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMoviesList(): Response<MoviesList>
}