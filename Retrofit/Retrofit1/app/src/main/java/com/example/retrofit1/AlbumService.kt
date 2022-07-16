package com.example.retrofit1

import com.example.retrofit1.models.Albums
import com.example.retrofit1.models.AlbumsItem
import retrofit2.Response
import retrofit2.http.*

interface AlbumService {
    @GET("albums")
    suspend fun getAlbums(): Response<Albums>

    @GET("albums")
    suspend fun getAlbumsParticularUserId(@Query("userId") userId : Int): Response<Albums>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId : Int): Response<AlbumsItem>

    @POST("albums")
    suspend fun uploadAlbum(@Body albumsItem: AlbumsItem): Response<AlbumsItem>

}