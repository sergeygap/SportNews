package com.gap.sportnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gap.sportnews.databinding.FragmentFavouritesBinding
import com.gap.sportnews.presentation.adapter.FavouritesAdapter
import com.gap.sportnews.presentation.adapter.NewsAdapter
import com.gap.sportnews.presentation.viewModels.FavouritesViewModel
import com.gap.sportnews.presentation.viewModels.NewsDetailsViewModel

class FavouritesFragment : Fragment() {
    private var _binding: FragmentFavouritesBinding? = null
    private val binding: FragmentFavouritesBinding
        get() = _binding ?: throw RuntimeException("FavouritesFragment == null")
    private val adapter by lazy {
        FavouritesAdapter(requireContext())
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[FavouritesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workWithAdapter()
        workWithViewModel()
    }

    private fun workWithViewModel() {
//        viewModel.getNewsList()
//        viewModel.newsLD.observe(viewLifecycleOwner) {
//            adapter.submitList(it)
//        }
    }
    private fun workWithAdapter() {
        binding.rvFavourites.adapter = adapter
        adapter.onNewsClickListener = object : FavouritesAdapter.OnNewsClickListener {
            override fun onNewsClick(id: Int) {
//                launchNewsDetailsFragment(id)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): Fragment = FavouritesFragment()
    }
}