package com.edstry.news.domain.usecase.settings

import com.edstry.news.domain.entity.Interval
import com.edstry.news.domain.entity.Language
import com.edstry.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(language: Language) {
        settingsRepository.updateLanguage(language)
    }
}