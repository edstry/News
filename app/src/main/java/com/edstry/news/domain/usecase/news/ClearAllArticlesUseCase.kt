package com.edstry.news.domain.usecase.news

import com.edstry.news.domain.repository.NewsRepository
import javax.inject.Inject

class ClearAllArticlesUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(topics: List<String>) {
        repository.clearAllArticles(topics)
    }
}