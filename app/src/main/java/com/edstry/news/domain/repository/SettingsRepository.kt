package com.edstry.news.domain.repository

import com.edstry.news.domain.entity.Language
import com.edstry.news.domain.entity.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getSettings(): Flow<Settings>
    suspend fun updateLanguage(language: Language)
    suspend fun updateInterval(minutes: Int)
    suspend fun updateNotificationsEnabled(enable: Boolean)
    suspend fun updateWifiOnly(wifiOnly: Boolean)
}