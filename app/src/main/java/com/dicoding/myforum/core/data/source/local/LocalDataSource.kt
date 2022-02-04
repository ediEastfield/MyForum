package com.dicoding.myforum.core.data.source.local

import com.dicoding.myforum.core.data.source.local.entity.AuthenticationEntity
import com.dicoding.myforum.core.data.source.local.room.ForumDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val forumDao: ForumDao) {

    fun getAuthentications(): Flow<AuthenticationEntity> = forumDao.getAuthentications()
    suspend fun insertToken(token: AuthenticationEntity) = forumDao.insertToken(token)
}