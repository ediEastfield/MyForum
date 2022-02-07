package com.dicoding.myforum.core.utils

import com.dicoding.myforum.core.data.source.local.entity.AuthenticationEntity
import com.dicoding.myforum.core.data.source.remote.response.DataLoginResponse
import com.dicoding.myforum.core.data.source.remote.response.RegisteredUserResponse
import com.dicoding.myforum.core.domain.model.DataLogin
import com.dicoding.myforum.core.domain.model.RegisteredUser

object DataMapper {

    fun mapRegisteredUserResponseToDomain(input: RegisteredUserResponse) = RegisteredUser (
        status = input.status
    )

    fun mapLoginResponsesToEntities(input: DataLoginResponse) = AuthenticationEntity(
        refreshToken = input.refreshToken,
        accessToken = input.accessToken
    )

    fun mapLoginEntitiesToDomain(input: AuthenticationEntity) = DataLogin(
        refreshToken = input.refreshToken,
        accessToken = input.accessToken
    )

}
