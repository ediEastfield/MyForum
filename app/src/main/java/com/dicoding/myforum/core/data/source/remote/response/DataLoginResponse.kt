package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataLoginResponse(

    @field:SerializedName("accessToken")
    val accessToken: String,

    @field:SerializedName("refreshToken")
    val refreshToken: String
)
