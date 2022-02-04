package com.dicoding.myforum.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Login(

    val refreshToken: String,
    val accessToken: String
): Parcelable
