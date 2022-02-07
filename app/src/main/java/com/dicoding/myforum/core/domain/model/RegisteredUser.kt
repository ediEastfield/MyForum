package com.dicoding.myforum.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisteredUser(

    val status: String?,
): Parcelable
