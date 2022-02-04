package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataUserResponse(

    @field:SerializedName("addedUser")
    val addedUser: AddedUserResponse
)
