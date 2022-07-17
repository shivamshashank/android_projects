package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.data.api.TMDBService
import com.example.tmdb_client.data.repository.movie.data_source.MovieRemoteDataSource
import com.example.tmdb_client.data.repository.movie.data_source_impl.MovieRemoteDataSourceImpl
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

}