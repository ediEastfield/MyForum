package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("username")
    val username: String
)
