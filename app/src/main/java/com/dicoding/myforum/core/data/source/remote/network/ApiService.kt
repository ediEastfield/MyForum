package com.dicoding.myforum.core.data.source.remote.network

import com.dicoding.myforum.core.data.source.remote.response.LoginRequest
import com.dicoding.myforum.core.data.source.remote.response.LoginResponse
import com.dicoding.myforum.core.data.source.remote.response.RegisterRequest
import com.dicoding.myforum.core.data.source.remote.response.RegisteredResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @POST("users")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    ) : RegisteredResponse

    @POST("authentications")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : LoginResponse
}