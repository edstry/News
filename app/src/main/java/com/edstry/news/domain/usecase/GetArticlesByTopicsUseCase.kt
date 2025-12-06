package com.edstry.news.domain.usecase

import com.edstry.news.domain.entity.Article
import com.edstry.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesByTopicsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(topics: List<String>): Flow<List<Article>> {
        return repository.getArticlesByTopics(topics)
    }
}