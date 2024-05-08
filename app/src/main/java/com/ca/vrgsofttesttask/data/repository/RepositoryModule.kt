package com.ca.vrgsofttesttask.data.repository

import com.ca.vrgsofttesttask.domain.repository.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindPostsRepository(repositoryImpl: PostsRepositoryImpl): PostsRepository
}