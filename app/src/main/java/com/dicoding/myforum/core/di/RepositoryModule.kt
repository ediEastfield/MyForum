package com.dicoding.myforum.core.di

import com.dicoding.myforum.core.data.ForumRepository
import com.dicoding.myforum.core.domain.repository.IForumRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(forumRepository: ForumRepository): IForumRepository
}