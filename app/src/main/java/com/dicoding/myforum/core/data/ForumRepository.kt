package com.dicoding.myforum.core.data

import com.dicoding.myforum.core.data.source.local.LocalDataSource
import com.dicoding.myforum.core.data.source.remote.RemoteDataSource
import com.dicoding.myforum.core.data.source.remote.network.ApiResponse
import com.dicoding.myforum.core.data.source.remote.response.DataLoginResponse
import com.dicoding.myforum.core.domain.model.DataLogin
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

    override fun login(username: String, password: String): Flow<Resource<DataLogin>> =
        object : NetworkBoundResource<DataLogin, DataLoginResponse>() {
            override fun loadFromDB(): Flow<DataLogin> {
                return localDataSource.getAuthentications().map { login ->
                    if (login != null) {
                        DataMapper.mapLoginEntitiesToDomain(login)
                    } else {
                        login
                    }
                }
            }

            override fun shouldFetch(data: DataLogin?): Boolean =
                data == null

            override suspend fun createCall(): Flow<ApiResponse<DataLoginResponse>> =
                remoteDataSource.login(username, password)

            override suspend fun saveCallResult(data: DataLoginResponse) {
                val token = DataMapper.mapLoginResponsesToEntities(data)
                localDataSource.insertToken(token)
            }
        }.asFlow()
}