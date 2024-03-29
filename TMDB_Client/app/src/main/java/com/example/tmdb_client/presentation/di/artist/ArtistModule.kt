package com.example.tmdb_client.presentation.di.artist

import com.example.tmdb_client.domain.use_cases.artists.GetArtistsListUseCase
import com.example.tmdb_client.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsListUseCase: GetArtistsListUseCase,
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsListUseCase,
        )
    }

}