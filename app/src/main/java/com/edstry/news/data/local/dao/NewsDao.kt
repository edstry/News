package com.edstry.news.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Transaction
import com.edstry.news.data.local.model.ArticleDbModel
import com.edstry.news.data.local.model.SubscriptionDbModel
import com.edstry.news.domain.entity.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM subscriptions")
    fun getAllSubscriptions(): Flow<List<SubscriptionDbModel>>

    @Insert(onConflict = IGNORE)
    suspend fun addSubscription(subscriptionDbModel: SubscriptionDbModel)

    @Transaction
    @Delete
    suspend fun deleteSubscription(subscriptionDbModel: SubscriptionDbModel)

    @Query("SELECT * FROM articles WHERE topic IN (:topics) ORDER BY publishedAt DESC")
    fun getAllArticlesByTopics(topics: List<String>): Flow<List<ArticleDbModel>>

    @Insert(onConflict = IGNORE)
    suspend fun addArticles(articles: List<ArticleDbModel>)

    @Query("DELETE FROM articles WHERE topic IN (:topics)")
    suspend fun deleteArticlesByTopics(topics: List<String>)
}