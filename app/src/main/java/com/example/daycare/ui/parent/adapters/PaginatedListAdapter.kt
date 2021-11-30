package com.example.daycare.ui.parent.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daycare.R

abstract class PaginatedListAdapter<VH : RecyclerView.ViewHolder, DATA>(
    val data: ArrayList<DATA>,
    val layout: Int,
    val loadMoreItems: () -> Unit
) :
    RecyclerView.Adapter<VH>() {

    private var hasMore = true

    abstract fun getViewHolder(view: View): VH
    abstract fun bindObjectToViewHolder(position: Int, holder: VH)

    override fun getItemViewType(position: Int): Int {
        return if (currentPositionIsTheLast(position)) 1 else 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val currentLayout = getCurrentLayout(viewType)
        val view = LayoutInflater.from(parent.context)
            .inflate(currentLayout, parent, false)
        return getViewHolder(view)
    }

    private fun getCurrentLayout(viewType: Int): Int {
        return if (viewType == 1) R.layout.loading_item else layout
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Log.d("nnnn","position = $position")
        if (currentPositionIsTheLast(position)) {
            loadMoreItems()
        } else {
            bindObjectToViewHolder(position, holder)
        }
    }

    fun addMoreData(more: List<DATA>) {
        if (more.isEmpty()) {
            hasMore = false
            notifyItemRemoved(data.size)
            return
        }
        Log.d("nnnn", "size = ${more.size}")
        data.addAll(more)
      //  notifyItemRangeInserted(data.size - more.size, more.size)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size + if (hasMore) 1 else 0
    private fun currentPositionIsTheLast(position: Int) = position == data.size
}