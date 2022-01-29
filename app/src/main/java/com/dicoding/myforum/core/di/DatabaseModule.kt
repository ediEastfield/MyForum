package com.dicoding.myforum.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.myforum.core.data.source.local.room.ForumDao
import com.dicoding.myforum.core.data.source.local.room.ForumDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ForumDatabase = Room.databaseBuilder(
        context,
        ForumDatabase::class.java,
        "forumapi.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideForumDao(database: ForumDatabase): ForumDao = database.forumDao()
}