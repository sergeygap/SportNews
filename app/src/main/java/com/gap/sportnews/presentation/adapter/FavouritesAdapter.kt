package com.gap.sportnews.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gap.sportnews.databinding.ItemNewsBinding
import com.gap.sportnews.domain.News
import com.squareup.picasso.Picasso

class FavouritesAdapter(
    private val context: Context
) : ListAdapter<News, NewsViewHolder>(NewsDiffCallback) {

    var onNewsClickListener: OnNewsClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        setUpItem(holder, news)
    }


    private fun setUpItem(
        holder: NewsViewHolder,
        news: News
    ) {
        with(holder.binding) {
            with(news) {
                tvTitle.text = title
                tvCountComments.text = commentCount.toString()
                tvDate.text = postedTime
                Picasso.get().load(socialImage).into(imageViewContent)
                root.setOnClickListener {
                    onNewsClickListener?.let {
                        it.onNewsClick(id)
                    }
                }
            }
        }
    }

    interface OnNewsClickListener {
        fun onNewsClick(id: Int)
    }


}