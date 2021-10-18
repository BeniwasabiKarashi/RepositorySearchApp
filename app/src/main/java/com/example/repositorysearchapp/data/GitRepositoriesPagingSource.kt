package com.example.repositorysearchapp.data

import androidx.paging.PagingSource
import com.example.repositorysearchapp.data.repository.GitRepositoriesRepository
import com.example.repositorysearchapp.model.LabelSearchResultItem
import retrofit2.HttpException
import java.io.IOException

class GitRepositoriesPagingSource(
    private val gitRepositoriesRepository: GitRepositoriesRepository,
    private val keyword: String,
    private val sort: String? = null,
    private val order: String? = null,
    private val perPage: Int = 30
): PagingSource<Int, LabelSearchResultItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LabelSearchResultItem> {
        return try {
            val currentPage = params.key ?: 1
            val repositories = gitRepositoriesRepository.fetchRepositories(q=keyword,sort=sort, order=order , perPage=perPage ,page=currentPage)
            LoadResult.Page(
                data = repositories.items,
                prevKey = currentPage - 1,
                nextKey = if (repositories.items.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}