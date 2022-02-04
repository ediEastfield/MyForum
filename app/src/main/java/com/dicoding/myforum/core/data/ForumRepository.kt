package com.dicoding.myforum.core.data

import android.util.Log
import com.dicoding.myforum.core.data.source.local.LocalDataSource
import com.dicoding.myforum.core.data.source.remote.RemoteDataSource
import com.dicoding.myforum.core.data.source.remote.network.ApiResponse
import com.dicoding.myforum.core.data.source.remote.response.DataLoginResponse
import com.dicoding.myforum.core.data.source.remote.response.LoginResponse
import com.dicoding.myforum.core.domain.model.AddedUser
import com.dicoding.myforum.core.domain.model.Login
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

    override fun register(username: String, password: String, fullname: String): Flow<AddedUser> {
        return remoteDataSource.register(username, password, fullname).map {
            DataMapper.mapAddedUserResponseToDomain(it)
        }
    }

    override fun login(username: String, password: String): Flow<Resource<Login>> =
        object : NetworkBoundResource<Login, DataLoginResponse>() {
            override fun loadFromDB(): Flow<Login> {
                return localDataSource.getAuthentications().map { login ->
                    if (login != null) {
                        DataMapper.mapLoginEntitiesToDomain(login)
                    } else {
                        login
                    }
                }
            }

            override fun shouldFetch(data: Login?): Boolean =
                data == null

            override suspend fun createCall(): Flow<ApiResponse<DataLoginResponse>> =
                remoteDataSource.login(username, password)

            override suspend fun saveCallResult(data: DataLoginResponse) {
                val token = DataMapper.mapLoginResponseToEntities(data)
                localDataSource.insertToken(token)
            }

        }.asFlow()

}