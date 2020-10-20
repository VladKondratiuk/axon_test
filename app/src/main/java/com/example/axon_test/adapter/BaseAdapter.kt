package com.example.axon_test.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.axon_test.adapter.item.BaseItem

abstract class BaseAdapter<V : RecyclerView.ViewHolder> : RecyclerView.Adapter<V>() {

    private var items = mutableListOf<BaseItem>()

    override fun getItemCount(): Int = items.size

    fun getItem(position: Int): BaseItem = items[position]

    fun getItems(): MutableList<BaseItem> = items

    fun resetItems(newList: List<BaseItem>) {
        items = newList.toMutableList()
        notifyDataSetChanged()
    }

    fun setItems(newList: List<BaseItem>) {
        items = newList.toMutableList()
    }
}
