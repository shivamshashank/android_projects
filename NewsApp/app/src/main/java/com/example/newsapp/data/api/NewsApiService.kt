package com.example.newsapp.data.api

import com.example.newsapp.BuildConfig
import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY,
    ): Response<NewsResponseModel>

}