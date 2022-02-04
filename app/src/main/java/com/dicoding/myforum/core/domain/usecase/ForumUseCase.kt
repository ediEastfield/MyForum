package com.dicoding.myforum.core.domain.usecase

import com.dicoding.myforum.core.data.Resource
import com.dicoding.myforum.core.domain.model.AddedUser
import com.dicoding.myforum.core.domain.model.Login
import kotlinx.coroutines.flow.Flow

interface ForumUseCase {

    fun register(username: String, password: String,fullname: String): Flow<AddedUser>
    fun login(username: String, password: String): Flow<Resource<Login>>
}