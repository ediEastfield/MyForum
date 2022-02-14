package com.dicoding.myforum.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: DataLoginResponse? = null,

	@field:SerializedName("status")
	val status: String
)