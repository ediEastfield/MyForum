package com.dicoding.myforum.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataLogin(

    var refreshToken: String? = null,
    var accessToken: String? = null
): Parcelable
