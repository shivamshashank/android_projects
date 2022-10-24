package com.example.newsapp.presentation.di

import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.use_cases.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(newsRepository)
    }

}