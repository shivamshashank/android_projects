package com.example.tmdb_client.domain.use_cases.tv_shows

import com.example.tmdb_client.data.models.tv_shows.TvShow
import com.example.tmdb_client.domain.repository.TvShowRepository

class GetTvShowsListUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShowsList()

}