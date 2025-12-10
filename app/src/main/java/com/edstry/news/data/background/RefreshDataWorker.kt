package com.edstry.news.data.background

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.edstry.news.domain.usecase.news.UpdateSubscribedArticlesUseCase
import com.edstry.news.domain.usecase.settings.GetSettingsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class RefreshDataWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val updateSubscribedArticlesUseCase: UpdateSubscribedArticlesUseCase,
    private val notificationsHelper: NotificationsHelper,
    private val getSettingsUseCase: GetSettingsUseCase
): CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        Log.d("RefreshDataWorker", "start")
        val settings = getSettingsUseCase().first()
        val updatedTopics = updateSubscribedArticlesUseCase()
        if(updatedTopics.isNotEmpty() && settings.notificationsEnabled) {
            notificationsHelper.showNewArticlesNotification(updatedTopics)
        }
        Log.d("RefreshDataWorker", "finish")
        return Result.success()
    }
}