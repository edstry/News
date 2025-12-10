package com.edstry.news.data.mapper

import com.edstry.news.domain.entity.RefreshConfig
import com.edstry.news.domain.entity.Settings

fun Settings.toRefreshConfig(): RefreshConfig {
    return RefreshConfig(
        language = language,
        interval = interval,
        wifiOnly = wifiOnly
    )
}