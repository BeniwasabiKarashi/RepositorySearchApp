package com.example.repositorysearchapp.data.repository

import com.example.repositorysearchapp.data.api.GitRepositoriesService
import com.example.repositorysearchapp.data.api.toModel
import com.example.repositorysearchapp.model.GitRepositories

interface GitRepositoriesRepository {
    suspend fun fetchRepositories(q: String,
                                  sort: String?,
                                  order: String?,
                                  perPage: Int?,
                                  page: Int?
    ): GitRepositories
}

class GitRepositoriesRepositoryImpl(
    private val gitRepositoriesService: GitRepositoriesService
): GitRepositoriesRepository {
    override suspend fun fetchRepositories(
        q: String,
        sort: String?,
        order: String?,
        perPage: Int?,
        page: Int?
    ): GitRepositories {
        return gitRepositoriesService.getRepositories(
            q = q,
            sort = sort,
            order = order,
            perPage = perPage,
            page = page
        ).toModel()
    }
}