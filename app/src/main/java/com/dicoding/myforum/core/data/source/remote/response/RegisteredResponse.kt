package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RegisteredResponse(

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("data")
    val data: Data
)

data class  Data(

    @field:SerializedName("addedUser")
    val addedUser: AddedUserResponse
)