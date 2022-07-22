package com.example.tmdb_client.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client.domain.use_cases.artists.GetArtistsListUseCase

class ArtistViewModel(private val getArtistsListUseCase: GetArtistsListUseCase) : ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsListUseCase.execute()
        emit(artistsList)
    }

}