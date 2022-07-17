package com.example.tmdb_client.domain.use_cases.artists

import com.example.tmdb_client.data.models.artist.Artist
import com.example.tmdb_client.domain.repository.ArtistRepository

class UpdateArtistsListUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtistsList()

}