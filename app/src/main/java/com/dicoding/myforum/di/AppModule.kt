package com.dicoding.myforum.di

import com.dicoding.myforum.core.domain.usecase.ForumInteractor
import com.dicoding.myforum.core.domain.usecase.ForumUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideForumUseCase(forumInteractor: ForumInteractor): ForumUseCase
}