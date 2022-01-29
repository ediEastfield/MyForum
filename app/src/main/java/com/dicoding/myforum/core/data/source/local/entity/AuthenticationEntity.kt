package com.dicoding.myforum.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authentications")
data class AuthenticationEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "token")
    var token: String
)
