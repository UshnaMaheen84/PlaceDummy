package com.example.placedummy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R

class ProjectDetailsAdapter : RecyclerView.Adapter<ProjectDetailsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_item_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

//    fun filterlist(search: String){
//        NoteList.clear()
//
//        for (item in fullList){
//
//            if (item.title?.lowercase()?.contains(search.lowercase())== true ||
//                item.note?.lowercase()?.contains(search.lowercase())== true){
//
//                NoteList.add(item)
//            }
//        }
//        notifyDataSetChanged()
//    }

    class ViewHolder (itemview : View): RecyclerView.ViewHolder(itemview){

    }
}