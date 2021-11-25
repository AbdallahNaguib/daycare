package com.example.daycare.ui.parent.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daycare.R
import com.example.daycare.ui.models.Activity

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
        holder.child.text = item.child
        holder.date.text = item.date
        holder.temp.text = item.temp
        holder.time.text = item.startTime
        holder.type.text = item.type
    }

    override fun getItemCount() = data.size
}