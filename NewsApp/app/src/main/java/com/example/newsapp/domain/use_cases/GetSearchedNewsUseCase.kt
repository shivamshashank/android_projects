package com.example.newsapp.domain.use_cases

import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import com.example.newsapp.data.util.Resource
import com.example.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<NewsResponseModel> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}