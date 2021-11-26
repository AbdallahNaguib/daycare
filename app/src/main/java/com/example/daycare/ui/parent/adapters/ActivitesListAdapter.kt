package com.example.daycare.ui.parent.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daycare.R
import com.example.daycare.domain.models.Activity

class ActivitesListAdapter(val data: List<Activity>) :
    MyBaseAdapter<ActivitesListAdapter.ViewHolder>(R.layout.activities_list_item) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val child: TextView = view.findViewById(R.id.activityChildDesc)
        val type: TextView = view.findViewById(R.id.activityTempDesc)
        val date: TextView = view.findViewById(R.id.activityDateDesc)
        val time: TextView = view.findViewById(R.id.activityTimeDesc)
        val temp: TextView = view.findViewById(R.id.activityTempDesc)
    }

    override fun getViewHolder(view: View) = ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.time.text = item.time
        holder.date.text = item.date
        holder.type.text = item.type
    }

    override fun getItemCount() = data.size
}