package com.dicoding.myforum.core.data.source.local

import com.dicoding.myforum.core.data.source.local.room.ForumDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val forumDao: ForumDao) {
}