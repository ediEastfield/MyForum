package com.dicoding.myforum.core.domain.repository

import com.dicoding.myforum.core.domain.model.AddedUser
import kotlinx.coroutines.flow.Flow

interface IForumRepository {

    fun register(username: String, password: String, fullname: String): Flow<AddedUser>
}