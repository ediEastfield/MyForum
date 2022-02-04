package com.dicoding.myforum.core.data.source.remote

import android.util.Log
import com.dicoding.myforum.core.data.source.remote.network.ApiResponse
import com.dicoding.myforum.core.data.source.remote.network.ApiService
import com.dicoding.myforum.core.data.source.remote.response.*
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
                val addUser = RegisterRequest(password, fullname, username)
                val response = apiService.register(addUser)
                val dataArray = response.data.addedUser

                emit(dataArray)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
                emit(AddedUserResponse("","",""))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun login(username: String, password: String): Flow<ApiResponse<DataLoginResponse>> {
        return flow {
            try {
                val loginRequest = LoginRequest(password, username)
                val response = apiService.login(loginRequest)
                val dataArray = response.data
                if (dataArray.refreshToken.isNotEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }

            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}