package com.dicoding.myforum.core.data

import com.dicoding.myforum.core.data.source.local.LocalDataSource
import com.dicoding.myforum.core.data.source.remote.RemoteDataSource
import com.dicoding.myforum.core.domain.model.Login
import com.dicoding.myforum.core.domain.model.RegisteredUser
import com.dicoding.myforum.core.domain.repository.IForumRepository
import com.dicoding.myforum.core.utils.AppExecutors
import com.dicoding.myforum.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForumRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IForumRepository {

    override fun register(username: String, password: String, fullname: String): Flow<RegisteredUser> {
        return remoteDataSource.register(username, password, fullname).map {
            DataMapper.mapRegisteredUserResponseToDomain(it)
        }
    }

    override fun login(username: String, password: String): Flow<Login> {
        return remoteDataSource.login(username, password).map { login ->
            if (login.status == "success") {
                DataMapper.mapLoginResponseToDomain(login)
            } else {
                Login(status = login.status)
            }
        }
    }

}