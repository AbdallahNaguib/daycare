package com.example.daycare.ui.parent.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.daycare.R
import com.example.daycare.domain.models.Absence

class AbsencesListAdapter(data: ArrayList<Absence>) :
    PaginatedListAdapter<AbsencesListAdapter.ViewHolder, Absence>(data, R.layout.absence_list_item) {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val className:TextView = view.findViewById(R.id.className)
        val date:TextView = view.findViewById(R.id.date)
        val comment:TextView = view.findViewById(R.id.comment)
        val name:TextView = view.findViewById(R.id.name)
    }

    override fun getViewHolder(view: View) = ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.className.text = item.group.title
        holder.date.text = item.date
        holder.comment.text = item.comment
        holder.name.text = item.child.name
    }
}