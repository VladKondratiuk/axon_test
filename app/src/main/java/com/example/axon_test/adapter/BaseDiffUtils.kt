package com.example.axon_test.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.axon_test.adapter.item.BaseItem

class BaseItemDiffUtilItemCallback<T : BaseItem> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return DiffHelper.areItemsTheSame(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return DiffHelper.areContentsTheSame(oldItem, newItem)
    }
}
