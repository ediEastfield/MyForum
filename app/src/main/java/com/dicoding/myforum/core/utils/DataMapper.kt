package com.dicoding.myforum.core.utils

import com.dicoding.myforum.core.data.source.remote.response.AddedUserResponse
import com.dicoding.myforum.core.domain.model.AddedUser

object DataMapper {

    fun mapAddedUserResponseToDomain(input: AddedUserResponse) = AddedUser(
        id = input.id,
        username = input.username,
        fullname = input.fullname
    )
}