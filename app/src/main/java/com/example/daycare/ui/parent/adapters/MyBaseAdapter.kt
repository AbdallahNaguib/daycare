package com.example.daycare.ui.parent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class MyBaseAdapter<T : RecyclerView.ViewHolder>(val layout: Int) :
    RecyclerView.Adapter<T>() {

    abstract fun getViewHolder(view:View): T

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return getViewHolder(view)
    }

}