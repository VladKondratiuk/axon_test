package com.example.axon_test.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.axon_test.adapter.item.BaseItem
import com.example.axon_test.adapter.item.BaseItemEnum
import com.example.axon_test.adapter.item.UserItem

object DiffHelper : DiffUtil.ItemCallback<BaseItem>() {

    override fun areItemsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
        if (oldItem.type != newItem.type) return false
        return when (newItem.type) {
            BaseItemEnum.USER -> (oldItem as UserItem).user.email == (newItem as UserItem).user.email
        }
    }

    override fun areContentsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
        if (oldItem.type != newItem.type)
            return false
        return when (newItem.type) {
            BaseItemEnum.USER -> (oldItem as UserItem) == newItem as UserItem
        }
    }

    override fun getChangePayload(oldItem: BaseItem, newItem: BaseItem): Any? {
        return null
    }
}
