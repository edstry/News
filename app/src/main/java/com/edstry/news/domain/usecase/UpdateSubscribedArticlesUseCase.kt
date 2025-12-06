package com.edstry.news.domain.usecase

import com.edstry.news.domain.repository.NewsRepository
import javax.inject.Inject

class UpdateSubscribedArticlesUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke() {
        repository.updateArticlesForAllSubscription()
    }
}