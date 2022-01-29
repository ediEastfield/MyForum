package com.dicoding.myforum.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.myforum.core.domain.usecase.ForumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val forumUseCase: ForumUseCase) : ViewModel() {

    fun register(username: String, password: String, fullname: String) =
        forumUseCase.register(username, password, fullname).asLiveData()
}