package com.example.repositorysearchapp.top

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.repositorysearchapp.databinding.LayoutGitRepositoryListItemBinding
import com.example.repositorysearchapp.model.LabelSearchResultItem

class TopGitRepositoryAdapter: PagingDataAdapter<LabelSearchResultItem, TopGitRepositoryAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(private val binding:LayoutGitRepositoryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: LabelSearchResultItem) {
            binding.apply {
                name.text = repository.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = LayoutGitRepositoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = getItem(position) ?: return
        holder.bind(repository)
    }

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<LabelSearchResultItem>() {
            override fun areItemsTheSame(
                oldItem: LabelSearchResultItem,
                newItem: LabelSearchResultItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: LabelSearchResultItem,
                newItem: LabelSearchResultItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}