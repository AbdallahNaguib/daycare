package com.example.daycare.ui.parent.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.daycare.Constants
import com.example.daycare.R
import com.example.daycare.domain.models.Child

class ChildrenListAdapter(data: ArrayList<Child>,val requestManager: RequestManager,val tenant:String) :
    PaginatedListAdapter<ChildrenListAdapter.ViewHolder, Child>(
        data,
        R.layout.children_list_item
    ) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idNumber:TextView = view.findViewById(R.id.ID_number)
        val name:TextView = view.findViewById(R.id.name)
        val icon:ImageView = view.findViewById(R.id.icon)
        val dateOfBirth:TextView = view.findViewById(R.id.data_of_birth)
        val bloodGroup:TextView = view.findViewById(R.id.blood_group)
        val className:TextView = view.findViewById(R.id.className)
    }

    override fun getViewHolder(view: View) = ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.idNumber.text = item.id_number
        holder.bloodGroup.text = item.blood_type
        holder.className.text = item.group.title
        holder.dateOfBirth.text = item.birth_date
        holder.name.text = item.name
        requestManager.load(Constants.IMAGE_URL(tenant,"small",item.image!!))
            .centerCrop()
            .into(holder.icon)
    }
}