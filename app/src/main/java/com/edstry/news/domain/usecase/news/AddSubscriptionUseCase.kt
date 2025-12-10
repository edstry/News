package com.edstry.news.domain.usecase.news

import com.edstry.news.domain.repository.NewsRepository
import com.edstry.news.domain.repository.SettingsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddSubscriptionUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    private val settingsRepository: SettingsRepository
) {

    // Получаем корутин контекс в котором выполняется данная suspend функция
    // Создать корутин скоуп, который будет содержать данный корутин контекст
    // И внутри этого скоупа запустить обновление статей
    suspend operator fun invoke(topic: String) {
        newsRepository.addSubscription(topic)
        CoroutineScope(currentCoroutineContext()).launch {
            val settings = settingsRepository.getSettings().first()
            newsRepository.updateArticlesForTopic(topic, settings.language)
        }

    }
}