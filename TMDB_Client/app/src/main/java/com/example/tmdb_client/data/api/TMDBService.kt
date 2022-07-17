package com.example.tmdb_client.data.api

import com.example.tmdb_client.data.models.artist.ArtistList
import com.example.tmdb_client.data.models.movie.MoviesList
import com.example.tmdb_client.data.models.tv_shows.TvShowsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MoviesList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowsList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>

}