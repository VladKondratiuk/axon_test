package com.example.axon_test.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.axon_test.adapter.ItemListener
import com.example.axon_test.adapter.binding.UserBinder
import com.example.axon_test.adapter.item.UserItem
import timber.log.Timber

class UserViewHolder(itemView: View, private val listener: ItemListener) :
    RecyclerView.ViewHolder(itemView) {

    lateinit var item: UserItem

    init {
        itemView.setOnClickListener { listener.onUserClick(item) }
    }

    fun bind(item: UserItem) {
        this.item = item
        UserBinder.bindName(itemView, item.user)
    }
}