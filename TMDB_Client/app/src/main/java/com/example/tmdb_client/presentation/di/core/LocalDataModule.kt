package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.data.db.dao.MoviesDao
import com.example.tmdb_client.data.repository.movie.data_source.MovieLocalDataSource
import com.example.tmdb_client.data.repository.movie.data_source_impl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(moviesDao: MoviesDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(moviesDao)
    }

}