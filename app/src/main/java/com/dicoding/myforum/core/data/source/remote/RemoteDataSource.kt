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

    fun login(username: String, password: String): Flow<LoginResponse> {
        return flow {
            try {
                val loginRequest = LoginRequest(password, username)
                val response = apiService.login(loginRequest)

                emit(response)
            } catch (e: Exception) {
                when (e) {
                    is IOException -> {
                        emit(LoginResponse(status = "Network Error"))
                    }
                    is HttpException -> {
                        val error = e.response()?.errorBody()!!.charStream().readText()
                        val msg = error.split(",")[1].split(":")[1].split('"')[1]
                        Log.e("RemoteDataSource", error)
                        Log.e("RemoteDataSource", msg)
                        emit(LoginResponse(status = msg))
                    }
                    else -> {
                        emit(LoginResponse(status = "Unknown Error"))
                    }
                }
            }
        }.flowOn(Dispatchers.IO)
    }
}