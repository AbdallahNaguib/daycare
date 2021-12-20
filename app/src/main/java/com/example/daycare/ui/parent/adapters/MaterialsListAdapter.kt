package com.example.daycare.ui.parent.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daycare.R
import com.example.daycare.domain.models.Material
import android.app.DownloadManager
import android.content.Context
import android.net.Uri

import androidx.core.content.ContextCompat.getSystemService


import android.os.Build
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.daycare.Constants
import java.util.*
import kotlin.collections.ArrayList


class MaterialsListAdapter(val context:Context,data: ArrayList<Material>) :
    PaginatedListAdapter<MaterialsListAdapter.ViewHolder, Material>(
        data,
        R.layout.learning_material_item_list
    ) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subject: TextView = view.findViewById(R.id.subject)
        val group: TextView = view.findViewById(R.id.className)
        val attach: TextView = view.findViewById(R.id.attach)
        val name: TextView = view.findViewById(R.id.title)
        val download: Button = view.findViewById(R.id.download)
    }

    override fun getViewHolder(view: View) = ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.subject.text = item.subject.title
        holder.group.text = item.group.title
        holder.attach.text = item.attachment
        holder.name.text = item.title
        holder.download.setOnClickListener {
            downloadFile(item.attachment!!)
        }
    }
    fun downloadFile(fileName:String) {
        val url = Constants.FILE_URL(fileName)
        Toast.makeText(context,"downloading",Toast.LENGTH_SHORT).show()
        val DownloadUrl: String = url
        val request1 = DownloadManager.Request(Uri.parse(DownloadUrl))
        request1.setDescription("Sample Music File") //appears the same in Notification bar while downloading
        request1.setTitle(fileName)
        request1.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request1.setDestinationInExternalFilesDir(
            context,
            "/360Daycare",
            fileName
        )
        val manager1 = getSystemService(context,DownloadManager::class.java)
        Objects.requireNonNull(manager1)?.enqueue(request1)
        if (DownloadManager.STATUS_SUCCESSFUL == 8) {
            Toast.makeText(context,"downloaded",Toast.LENGTH_LONG).show()
        }
    }
}