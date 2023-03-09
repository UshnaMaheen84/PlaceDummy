package com.example.placedummy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R
import com.example.placedummy.model.Item

class DealerAdapter(val userList: List<Item>):
    RecyclerView.Adapter<DealerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dealer_item_view,parent,false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dealer= userList[position]
        holder.name.text= dealer.item[position].name
    }


    override fun getItemCount()= userList.size


    class ViewHolder (itemview : View): RecyclerView.ViewHolder(itemview){
        val imageview: ImageView = itemView.findViewById(R.id.deleteImg)
        val name: TextView = itemView.findViewById(R.id.dealerName)

    }


}