package com.example.newsapp.domain.use_cases

import com.example.newsapp.data.model.news_response_model.Article
import com.example.newsapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}