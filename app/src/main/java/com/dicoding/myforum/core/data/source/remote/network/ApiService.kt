package com.dicoding.myforum.core.data.source.remote.network

import com.dicoding.myforum.core.data.source.remote.response.RegisteredResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("users")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("fullname") fullname: String
    ) : RegisteredResponse
}