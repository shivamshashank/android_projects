package com.example.newsapp.data.repository.data_source

import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getNews(country: String, page: Int): Response<NewsResponseModel>

}