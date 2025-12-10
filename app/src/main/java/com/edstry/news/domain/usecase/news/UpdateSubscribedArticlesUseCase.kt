package com.edstry.news.domain.usecase.news

import com.edstry.news.domain.repository.NewsRepository
import com.edstry.news.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UpdateSubscribedArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(): List<String> {
        val settings = settingsRepository.getSettings().first()
        return newsRepository.updateArticlesForAllSubscription(settings.language)
    }
}