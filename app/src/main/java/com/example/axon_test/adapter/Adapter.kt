package com.example.axon_test.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.axon_test.adapter.item.BaseItem

class Adapter<T: BaseItem>(
    var itemListener: ItemListener = object : ItemListener {},
    diffCallback: DiffUtil.ItemCallback<T> = BaseItemDiffUtilItemCallback(),
    private val packer: Packer = Packer()
) : BaseAdapter<T, RecyclerView.ViewHolder>(diffCallback) {

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return packer.onCreateViewHolder(parent, viewType, itemListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        packer.onBindViewHolder(holder, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return packer.getItemType(getItem(position))
    }
}
