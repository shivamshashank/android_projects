package com.example.tmdb_client.presentation.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client.domain.use_cases.tv_shows.GetTvShowsListUseCase

class TvShowsViewModel(
    private val getTvShowsListUseCase: GetTvShowsListUseCase,
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowsList = getTvShowsListUseCase.execute()
        emit(tvShowsList)
    }

}