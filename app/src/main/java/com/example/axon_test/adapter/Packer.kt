package com.example.axon_test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.axon_test.R
import com.example.axon_test.adapter.item.BaseItem
import com.example.axon_test.adapter.item.BaseItemEnum
import com.example.axon_test.adapter.item.UserItem
import com.example.axon_test.adapter.viewholder.UserViewHolder

class Packer {

    fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
        itemListener: ItemListener
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            BaseItemEnum.USER.id -> UserViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user, parent, false), itemListener
            )
            else -> UserViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user, parent, false), itemListener
            )
        }
    }

    fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: BaseItem?
    ) {
        when (item?.type) {
            BaseItemEnum.USER ->
                (holder as UserViewHolder).bind(item as UserItem)
        }
    }

    fun getItemViewType(item: BaseItem?): Int {
        return item?.type?.id ?: -1
    }
}