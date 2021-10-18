package com.example.repositorysearchapp.top

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.repositorysearchapp.data.GitRepositoriesPagingSource
import com.example.repositorysearchapp.data.repository.GitRepositoriesRepository
import com.example.repositorysearchapp.model.LabelSearchResultItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    private val gitRepositoriesRepository: GitRepositoriesRepository
): ViewModel()
{
    fun fetchGitRepositories(keyword: String): Pager<Int, LabelSearchResultItem> {
        return Pager(PagingConfig(pageSize = 30, initialLoadSize = 30)) {
            GitRepositoriesPagingSource(
                gitRepositoriesRepository,
                keyword = keyword,
                sort = null,
                order = null,
                perPage = 30
            )
        }

    }
}