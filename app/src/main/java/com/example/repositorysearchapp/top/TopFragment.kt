package com.example.repositorysearchapp.top

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.liveData
import com.example.repositorysearchapp.R
import com.example.repositorysearchapp.databinding.FragmentTopBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopFragment: Fragment(R.layout.fragment_top) {
    private val viewModel: TopViewModel by viewModels()

    private val binding by viewBinding(FragmentTopBinding::bind)

    private val pagingRepositoryListAdapter = TopGitRepositoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchGitRepositories("Android")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.repositoryListRecyclerView.adapter = pagingRepositoryListAdapter

        binding.repositorySearchTextField.setEndIconOnClickListener {
            val keyword = binding.repositorySearchTextField.editText?.text.toString()
            if (keyword != "") {
                viewModel.fetchGitRepositories(keyword).liveData.observe(viewLifecycleOwner) { pagingData ->
                    lifecycleScope.launch {
                        pagingRepositoryListAdapter.submitData(pagingData)
                        pagingRepositoryListAdapter.notifyDataSetChanged()
                    }
                }
            }
        }

        binding.repositoryTextEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.repositorySearchTextField.isEndIconVisible = s?.length != 0
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.repositoryListRecyclerView.setOnClickListener {
            hideSoftKeyBoard()
        }
    }

    private fun hideSoftKeyBoard() {
        val inputManager = requireActivity().getSystemService<InputMethodManager>() ?:return
        inputManager.hideSoftInputFromWindow(view?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}