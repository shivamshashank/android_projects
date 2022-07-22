package com.example.tmdb_client.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_client.domain.use_cases.artists.GetArtistsListUseCase

class ArtistViewModelFactory(
    private val getArtistsListUseCase: GetArtistsListUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ArtistViewModel(getArtistsListUseCase) as T
        }

        throw IllegalArgumentException("Unknown Artists View Model Class")
    }

}