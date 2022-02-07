package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RegisterRequest(

    @field:SerializedName("password")
    val password: String? =null,

    @field:SerializedName("fullname")
    val fullname: String? =null,

    @field:SerializedName("username")
    val username: String? = null
)
