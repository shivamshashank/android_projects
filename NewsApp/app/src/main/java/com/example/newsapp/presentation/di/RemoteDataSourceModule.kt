package com.example.newsapp.presentation.di

import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.data.repository.data_source.NewsRemoteDataSource
import com.example.newsapp.data.repository.data_source_impl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsApiService: NewsApiService,
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }

}