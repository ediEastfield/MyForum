package com.dicoding.myforum.core.data.source.remote

import android.util.Log
import com.dicoding.myforum.core.data.source.remote.network.ApiResponse
import com.dicoding.myforum.core.data.source.remote.network.ApiService
import com.dicoding.myforum.core.data.source.remote.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun register(username: String, password: String, fullname: String): Flow<RegisteredUserResponse> {
        return flow {
            try {
                val addUser = RegisterRequest(password, fullname, username)
                val response = apiService.register(addUser)

                emit(response)
            } catch (e : Exception) {
                when (e) {
                    is IOException -> {
                        emit(RegisteredUserResponse(status = "Network Error"))
                    }
                    is HttpException -> {
                        val error = e.response()?.errorBody()!!.charStream().readText()
                        val msg = error.split(",")[1].split(":")[1].split('"')[1]
                        Log.e("RemoteDataSource", error)
                        Log.e("RemoteDataSource", msg)
                        emit(RegisteredUserResponse(status = msg))
                    }
                    else -> {
                        emit(RegisteredUserResponse(status = "Unknown Error"))
                    }
                }
            }
        }.flowOn(Dispatchers.IO)
    }

    fun login(username: String, password: String): Flow<ApiResponse<DataLoginResponse>> {
        return flow {
            try {
                val loginRequest = LoginRequest(password, username)
                val response = apiService.login(loginRequest)
                val dataArray = response.data

                if (response.status.equals("success")) {
                    emit(ApiResponse.Success(dataArray!!))
                } else {
                    emit(ApiResponse.Empty)
                }

            } catch (e: Exception) {
                when(e) {
                    is IOException -> {
                        emit(ApiResponse.Error("Network Error"))
                    }
                    is HttpException -> {
                        val error = e.response()?.errorBody()!!.charStream().readText()
                        val msg = error.split(",")[1].split(":")[1].split('"')[1]
                        Log.e("RemoteDataSource", error)
                        Log.e("RemoteDataSource", msg)
                        emit(ApiResponse.Error(msg))
                    }
                    else -> {
                        emit(ApiResponse.Error("Unknown Error"))
                    }
                }
            }
        }.flowOn(Dispatchers.IO)
    }
}