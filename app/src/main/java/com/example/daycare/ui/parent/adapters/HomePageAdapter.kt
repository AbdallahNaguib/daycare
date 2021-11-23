package com.example.daycare.ui.parent.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.example.daycare.R
import com.example.daycare.ui.models.HomePageAction

class HomePageAdapter(private val homepageActions:List<HomePageAction>) : RecyclerView.Adapter<HomePageAdapter.ViewHolder>() {
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val icon:ImageView = view.findViewById(R.id.icon)
        val mainLabel:TextView = view.findViewById(R.id.mainLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_homepage_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = homepageActions[position]
        holder.icon.setBackgroundResource(item.icon)
        holder.mainLabel.text = item.mainLabel
    }

    override fun getItemCount() = homepageActions.size
}