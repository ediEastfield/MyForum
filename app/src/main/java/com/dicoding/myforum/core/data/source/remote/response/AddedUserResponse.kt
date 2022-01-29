package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AddedUserResponse(

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("fullname")
    val fullname: String,

    @field:SerializedName("username")
    val username: String
)
