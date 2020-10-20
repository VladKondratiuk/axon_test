package com.example.axon_test.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    var itemListener: ItemListener = object : ItemListener {},
    private val packer: Packer = Packer()
) : BaseAdapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return packer.onCreateViewHolder(parent, viewType, itemListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        packer.onBindViewHolder(holder, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return packer.getItemViewType(getItem(position))
    }
}
