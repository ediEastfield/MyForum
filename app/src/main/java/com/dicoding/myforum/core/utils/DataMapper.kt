package com.dicoding.myforum.core.utils

import com.dicoding.myforum.core.data.source.local.entity.AuthenticationEntity
import com.dicoding.myforum.core.data.source.remote.response.AddedUserResponse
import com.dicoding.myforum.core.data.source.remote.response.DataLoginResponse
import com.dicoding.myforum.core.domain.model.AddedUser
import com.dicoding.myforum.core.domain.model.Login

object DataMapper {

    fun mapAddedUserResponseToDomain(input: AddedUserResponse) = AddedUser(
        id = input.id,
        username = input.username,
        fullname = input.fullname
    )

    fun mapLoginEntitiesToDomain(input: AuthenticationEntity) = Login(
        refreshToken = input.refreshToken,
        accessToken = input.accessToken
    )

    fun mapLoginResponseToEntities(input: DataLoginResponse) = AuthenticationEntity(
        accessToken = input.accessToken,
        refreshToken = input.refreshToken
    )
}