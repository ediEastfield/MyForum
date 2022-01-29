package com.dicoding.myforum.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddedUser(

    val id: String,
    val fullname: String,
    val username: String

): Parcelable
