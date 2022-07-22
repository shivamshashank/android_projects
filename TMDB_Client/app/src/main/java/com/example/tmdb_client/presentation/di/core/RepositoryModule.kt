package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdb_client.data.repository.artist.data_source.ArtistRemoteDataSource
import com.example.tmdb_client.data.repository.movie.MovieRepositoryImpl
import com.example.tmdb_client.data.repository.movie.data_source.MovieCacheDataSource
import com.example.tmdb_client.data.repository.movie.data_source.MovieLocalDataSource
import com.example.tmdb_client.data.repository.movie.data_source.MovieRemoteDataSource
import com.example.tmdb_client.data.repository.tv_show.TvShowRepositoryImpl
import com.example.tmdb_client.data.repository.tv_show.data_source.TvShowRemoteDataSource
import com.example.tmdb_client.domain.repository.ArtistRepository
import com.example.tmdb_client.domain.repository.MovieRepository
import com.example.tmdb_client.domain.repository.TvShowRepository
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

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
    ): ArtistRepository = ArtistRepositoryImpl(
        artistRemoteDataSource
    )

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ): TvShowRepository = TvShowRepositoryImpl(
        tvShowRemoteDataSource
    )

}