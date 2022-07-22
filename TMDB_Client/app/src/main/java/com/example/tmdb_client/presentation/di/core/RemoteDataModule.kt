package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.data.api.TMDBService
import com.example.tmdb_client.data.repository.artist.data_source.ArtistRemoteDataSource
import com.example.tmdb_client.data.repository.artist.data_source_impl.ArtistRemoteDataSourceImpl
import com.example.tmdb_client.data.repository.movie.data_source.MovieRemoteDataSource
import com.example.tmdb_client.data.repository.movie.data_source_impl.MovieRemoteDataSourceImpl
import com.example.tmdb_client.data.repository.tv_show.data_source.TvShowRemoteDataSource
import com.example.tmdb_client.data.repository.tv_show.data_source_impl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource =
        TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )

}