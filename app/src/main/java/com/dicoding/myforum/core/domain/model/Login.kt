package com.dicoding.myforum.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Login(

    val status: String,
    val data: DataLogin? = null
): Parcelable
