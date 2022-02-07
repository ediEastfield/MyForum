package com.dicoding.myforum.core.domain.usecase

import com.dicoding.myforum.core.data.Resource
import com.dicoding.myforum.core.domain.model.DataLogin
import com.dicoding.myforum.core.domain.model.RegisteredUser
import kotlinx.coroutines.flow.Flow

interface ForumUseCase {

    fun register(username: String, password: String,fullname: String): Flow<RegisteredUser>
    fun login(username: String, password: String): Flow<Resource<DataLogin>>
}