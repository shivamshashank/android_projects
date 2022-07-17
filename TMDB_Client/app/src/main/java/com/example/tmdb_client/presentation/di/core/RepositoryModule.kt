package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.data.repository.movie.MovieRepositoryImpl
import com.example.tmdb_client.data.repository.movie.data_source.MovieCacheDataSource
import com.example.tmdb_client.data.repository.movie.data_source.MovieLocalDataSource
import com.example.tmdb_client.data.repository.movie.data_source.MovieRemoteDataSource
import com.example.tmdb_client.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
    ): MovieRepository = MovieRepositoryImpl(
        movieRemoteDataSource,
        movieLocalDataSource,
        movieCacheDataSource
    )

}