package com.example.daycare.ui.parent.adapters

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.daycare.Constants
import com.example.daycare.R
import com.example.daycare.domain.models.Activity

class ActivitiesListAdapter(val data: List<Activity>, val tenant:String, val requestManager: RequestManager,val context:Context) :
    MyBaseAdapter<ActivitiesListAdapter.ViewHolder>(R.layout.activities_list_item) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val child: TextView = view.findViewById(R.id.activityChildDesc)
        val type: TextView = view.findViewById(R.id.activityTypeDesc)
        val date: TextView = view.findViewById(R.id.activityDateDesc)
        val time: TextView = view.findViewById(R.id.activityTimeDesc)
        val others: RecyclerView = view.findViewById(R.id.others)
        val image: ImageView = view.findViewById(R.id.imageView)
    }

    override fun getViewHolder(view: View) = ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.time.text = item.time
        holder.date.text = item.date
        holder.child.text = item.child.name
        holder.type.text = item.type.title
        holder.others.adapter = ActivitiesTextviewListAdapter(data[position].other)
        holder.others.layoutManager = LinearLayoutManager(context)
        requestManager
            .load(Constants.IMAGE_URL(tenant, "large", item.image!!))
            .centerCrop()
            .into(holder.image)
    }

    override fun getItemCount() = data.size
}