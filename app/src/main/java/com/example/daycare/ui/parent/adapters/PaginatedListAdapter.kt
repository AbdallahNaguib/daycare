package com.example.daycare.ui.parent.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daycare.R

abstract class PaginatedListAdapter<VH : RecyclerView.ViewHolder, DATA>(
    val data: ArrayList<DATA>,
    val layout: Int) :
    RecyclerView.Adapter<VH>() {

    abstract fun getViewHolder(view: View): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return getViewHolder(view)
    }

    fun addMoreData(more: List<DATA>) {
        data.addAll(more)
        notifyItemRangeInserted(data.size - more.size, more.size)
    }

    override fun getItemCount() = data.size
}