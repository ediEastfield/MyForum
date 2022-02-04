package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RegisteredResponse(

    @field:SerializedName("data")
    val data: DataUserResponse,

    @field:SerializedName("status")
    val status: String
)
