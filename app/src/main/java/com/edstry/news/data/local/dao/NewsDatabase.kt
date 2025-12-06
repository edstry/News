package com.edstry.news.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edstry.news.data.local.model.ArticleDbModel
import com.edstry.news.data.local.model.SubscriptionDbModel

@Database(
    entities = [ArticleDbModel::class, SubscriptionDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun newsDao(): NewsDao
}