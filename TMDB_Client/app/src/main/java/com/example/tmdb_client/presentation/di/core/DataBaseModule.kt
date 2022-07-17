package com.example.tmdb_client.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb_client.data.db.TMDBDatabase
import com.example.tmdb_client.data.db.dao.MoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
     return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdb_client")
         .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MoviesDao{
        return tmdbDatabase.moviesDao()
    }

}