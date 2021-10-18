package com.example.repositorysearchapp.data.repository

import com.example.repositorysearchapp.data.api.GitRepositoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class GitRepositoriesRepositoryModule {
    @Provides
    fun provideGitRepositoriesRepository(gitRepositoriesService: GitRepositoriesService): GitRepositoriesRepository {
        return GitRepositoriesRepositoryImpl(gitRepositoriesService)
    }
}