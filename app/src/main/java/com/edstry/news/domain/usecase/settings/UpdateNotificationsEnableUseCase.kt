package com.edstry.news.domain.usecase.settings

import com.edstry.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateNotificationsEnableUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(enabled: Boolean) {
        settingsRepository.updateNotificationsEnabled(enabled)
    }
}