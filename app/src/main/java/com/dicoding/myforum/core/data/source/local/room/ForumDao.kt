package com.dicoding.myforum.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.myforum.core.data.source.local.entity.AuthenticationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ForumDao {

    @Query("SELECT * FROM authentications")
    fun getAuthentications(): Flow<AuthenticationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToken(token: AuthenticationEntity)
}