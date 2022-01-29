package com.dicoding.myforum.core.data.source.remote

import android.util.Log
import com.dicoding.myforum.core.data.source.remote.network.ApiService
import com.dicoding.myforum.core.data.source.remote.response.AddedUserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun register(username: String, password: String, fullname: String): Flow<AddedUserResponse> {
        return flow {
            try {
                val response = apiService.register(username, password, fullname)
                val dataArray = response.data.addedUser
                emit(dataArray)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}