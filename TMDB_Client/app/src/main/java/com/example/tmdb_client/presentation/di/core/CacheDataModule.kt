package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.data.repository.movie.data_source.MovieCacheDataSource
import com.example.tmdb_client.data.repository.movie.data_source_impl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

}