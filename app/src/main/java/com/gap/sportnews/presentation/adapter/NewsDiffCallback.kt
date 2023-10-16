package com.gap.sportnews.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gap.sportnews.domain.News

object NewsDiffCallback: DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}