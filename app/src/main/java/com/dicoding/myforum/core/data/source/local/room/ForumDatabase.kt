package com.dicoding.myforum.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.myforum.core.data.source.local.entity.AuthenticationEntity

@Database(
    entities = [AuthenticationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ForumDatabase : RoomDatabase() {

    abstract fun forumDao(): ForumDao
}