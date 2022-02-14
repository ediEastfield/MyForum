package com.dicoding.myforum.core.utils

import com.dicoding.myforum.core.data.source.remote.response.DataLoginResponse
import com.dicoding.myforum.core.data.source.remote.response.LoginResponse
import com.dicoding.myforum.core.data.source.remote.response.RegisteredUserResponse
import com.dicoding.myforum.core.domain.model.DataLogin
import com.dicoding.myforum.core.domain.model.Login
import com.dicoding.myforum.core.domain.model.RegisteredUser

object DataMapper {

    fun mapRegisteredUserResponseToDomain(input: RegisteredUserResponse) = RegisteredUser (
        status = input.status
    )

    fun mapLoginResponseToDomain(input: LoginResponse) = Login(
        status = input.status,
        data = mapDataLoginResponsesToDomain(input.data!!)
    )

    private fun mapDataLoginResponsesToDomain(input: DataLoginResponse) = DataLogin(
        refreshToken = input.refreshToken,
        accessToken = input.accessToken
    )

}
