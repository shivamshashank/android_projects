package com.example.newsapp.presentation.di

import android.app.Application
import com.example.newsapp.domain.use_cases.GetNewsUseCase
import com.example.newsapp.presentation.news.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        app: Application,
        getNewsUseCase: GetNewsUseCase,
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            app,
            getNewsUseCase,
        )
    }

}