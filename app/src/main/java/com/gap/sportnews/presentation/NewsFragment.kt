package com.gap.sportnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gap.sportnews.R
import com.gap.sportnews.databinding.FragmentNewsBinding
import com.gap.sportnews.presentation.adapter.NewsAdapter
import com.gap.sportnews.presentation.viewModels.NewsViewModel

class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding: FragmentNewsBinding
        get() = _binding ?: throw RuntimeException("NewsFragment == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[NewsViewModel::class.java]
    }
    private val adapter: NewsAdapter by lazy {
        NewsAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workWithAdapter()
        workWithViewModel()
        workWithSwipeToRefresh()
    }

    private fun workWithSwipeToRefresh() {
        binding.swipeToRefreshLayout.setOnRefreshListener {
            viewModel.updateNewsList()
            binding.swipeToRefreshLayout.isRefreshing = false
        }
    }

    private fun workWithViewModel() {
        viewModel.getNewsList()
        viewModel.newsLD.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun workWithAdapter() {
        binding.mainRecyclerView.adapter = adapter
        adapter.onNewsClickListener = object :NewsAdapter.OnNewsClickListener {
            override fun onNewsClick(id: Int) {
                launchNewsDetailsFragment(id)
            }
        }
        adapter.onReachEndListener = object : NewsAdapter.OnReachEndListener {
            override fun onReachEnd() {
                viewModel.getNewsList()
            }
        }
    }

    private fun launchNewsDetailsFragment(id: Int) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, NewsDetailsFragment.newInstance(id))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): Fragment = NewsFragment()
    }
}