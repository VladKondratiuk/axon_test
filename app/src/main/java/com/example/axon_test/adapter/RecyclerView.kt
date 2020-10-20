package com.example.axon_test.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerView : RecyclerView {

    private var emptyView: View? = null

    private val dataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
            updateEmptyView()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            updateEmptyView()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            updateEmptyView()
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    override fun setAdapter(adapter: Adapter<*>?) {
        getAdapter()?.unregisterAdapterDataObserver(dataObserver)
        adapter?.registerAdapterDataObserver(dataObserver)
        super.setAdapter(adapter)
        updateEmptyView()
    }

    private fun updateEmptyView() {
        val emptyView = this.emptyView
        val adapter = this.adapter
        if (emptyView != null && adapter != null) {
            val showEmptyView = adapter.itemCount == 0
            emptyView.visibility = if (showEmptyView) View.VISIBLE else View.GONE
            this.visibility = if (showEmptyView) View.GONE else View.VISIBLE
        }
    }
}
