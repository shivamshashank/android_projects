package com.example.newsapp.domain.use_cases

import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import com.example.newsapp.data.util.Resource
import com.example.newsapp.domain.repository.NewsRepository

class GetNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, page: Int): Resource<NewsResponseModel> {
        return newsRepository.getNews(country, page)
    }
}