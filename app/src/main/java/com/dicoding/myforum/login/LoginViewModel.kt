package com.dicoding.myforum.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.myforum.core.domain.usecase.ForumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val forumUseCase: ForumUseCase) : ViewModel() {
    fun login(username: String, password: String) = forumUseCase.login(username, password).asLiveData()
}