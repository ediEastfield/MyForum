package com.dicoding.myforum.core.domain.usecase

import com.dicoding.myforum.core.domain.model.AddedUser
import kotlinx.coroutines.flow.Flow

interface ForumUseCase {

    fun register(username: String, password: String,fullname: String): Flow<AddedUser>
}