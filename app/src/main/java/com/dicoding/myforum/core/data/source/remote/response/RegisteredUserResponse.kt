package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RegisteredUserResponse(

    @field:SerializedName("status")
    val status: String? = null
)