package com.example.newsapp.data.repository.data_source_impl

import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import com.example.newsapp.data.repository.data_source.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService,
) : NewsRemoteDataSource {
    override suspend fun getNews(country: String, page: Int): Response<NewsResponseModel> {
        return newsApiService.getNews(country, page)
    }
}