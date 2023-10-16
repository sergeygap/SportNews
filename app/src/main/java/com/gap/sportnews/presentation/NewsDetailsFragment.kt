package com.gap.sportnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gap.sportnews.R
import com.gap.sportnews.databinding.FragmentNewsDetailsBinding
import com.gap.sportnews.presentation.viewModels.NewsDetailsViewModel
import com.squareup.picasso.Picasso

class NewsDetailsFragment : Fragment() {
    private var _binding: FragmentNewsDetailsBinding? = null
    private val binding: FragmentNewsDetailsBinding
        get() = _binding ?: throw RuntimeException("NewsDetailsFragment == null")
    private var id: Int = UNDEFINED_ID

    private val viewModel: NewsDetailsViewModel by lazy {
        ViewModelProvider(this)[NewsDetailsViewModel::class.java]
    }

    private var stateFavourite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = requireArguments().getInt(ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workWithViewModel()
        workWithUI()
    }

    private fun workWithUI() {
        val constraintLayout =
            requireActivity().findViewById<ConstraintLayout>(R.id.bottomNavigationView)
        constraintLayout.visibility = View.GONE
        val activity = requireActivity()
        if (activity is AppCompatActivity) {
            activity.setSupportActionBar(binding.mainToolbarCommunication)
            activity.supportActionBar?.title = ""
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            activity.supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow)
        }
        binding.mainToolbarCommunication.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.toolbarImage.setOnClickListener {
            stateFavourite = !stateFavourite
            if (stateFavourite) {
                binding.toolbarImage.setImageResource(R.drawable.ic_favourite_selected)
                viewModel.addToDb(id.toLong())
            } else {
                binding.toolbarImage.setImageResource(R.drawable.ic_favourite)
                viewModel.deleteInDb(id.toLong())
            }
        }

    }

    private fun workWithViewModel() {
        viewModel.loadData(id)
        viewModel.newLD.observe(viewLifecycleOwner) {
            with(binding) {
                Picasso.get().load(it.socialImage).into(imageViewContent)
                tvTitle.text = it.title
                tvBodyNews.text = it.content
                tvCountComments.text = it.commentCount.toString()
                tvDate.text = it.postedTime
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ID = "id"
        private const val UNDEFINED_ID = -1
        fun newInstance(id: Int): Fragment {
            return NewsDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID, id)
                }
            }
        }
    }
}