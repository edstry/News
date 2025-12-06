package com.edstry.news.domain.usecase

import com.edstry.news.domain.repository.NewsRepository
import javax.inject.Inject

class GetAllSubscriptionsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke() = repository.getAllSubscriptions()
}