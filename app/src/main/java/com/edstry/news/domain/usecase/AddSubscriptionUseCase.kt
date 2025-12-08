package com.edstry.news.domain.usecase

import com.edstry.news.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class AddSubscriptionUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    // Получаем корутин контекс в котором выполняется данная suspend функция
    // Создать корутин скоуп, который будет содержать данный корутин контекст
    // И внутри этого скоупа запустить обновление статей
    suspend operator fun invoke(topic: String) {
        repository.addSubscription(topic)
        CoroutineScope(currentCoroutineContext()).launch {
            repository.updateArticlesForTopic(topic)
        }

    }
}