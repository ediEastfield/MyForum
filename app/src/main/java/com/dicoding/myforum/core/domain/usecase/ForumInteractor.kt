package com.dicoding.myforum.core.domain.usecase

import com.dicoding.myforum.core.data.Resource
import com.dicoding.myforum.core.domain.model.DataLogin
import com.dicoding.myforum.core.domain.repository.IForumRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ForumInteractor @Inject constructor(private val forumRepository: IForumRepository): ForumUseCase {

    override fun register(username: String, password: String, fullname: String) = forumRepository.register(username, password, fullname)
    override fun login(username: String, password: String) = forumRepository.login(username, password)
}