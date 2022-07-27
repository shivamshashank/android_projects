package com.example.tmdb_client.presentation.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_client.domain.use_cases.tv_shows.GetTvShowsListUseCase

class TvShowsViewModelFactory(
    private val getTvShowsListUseCase: GetTvShowsListUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TvShowsViewModel(getTvShowsListUseCase) as T
        }

        throw IllegalArgumentException("Unknown Tv Show View Model Class")
    }
}