package com.example.daycare.ui.parent.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daycare.R
import com.example.daycare.Utils

class ActivitiesTextviewListAdapter(val data: Map<String, String>) :
    MyBaseAdapter<ActivitiesTextviewListAdapter.ViewHolder>(R.layout.activity_text_view_list_item) {

    val keys = data.keys.toTypedArray()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title);
        val desc: TextView = view.findViewById(R.id.desc);
    }

    override fun getViewHolder(view: View) = ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = keys[position]
        val value = data[title]
        holder.title.text = Utils.convertKeyToName(title)
        holder.desc.text = value
    }

    override fun getItemCount() = data.size
}