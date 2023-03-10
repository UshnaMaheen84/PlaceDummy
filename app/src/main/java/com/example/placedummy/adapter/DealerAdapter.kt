package com.example.placedummy.adapter

import android.provider.ContactsContract
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R
import com.example.placedummy.model.Dealer

class DealerAdapter():
    RecyclerView.Adapter<DealerAdapter.ViewHolder>() {

    val fullList = ArrayList<Dealer>()
    val userList= ArrayList<Dealer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dealer_item_view,parent,false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dealer= userList[position]
        holder.name.text= dealer.name
    }


    override fun getItemCount()= userList.size

    fun filterlist(search: String){
        userList.clear()

        for (item in fullList){

            if (item.name?.lowercase()?.contains(search.lowercase())== true ){

                userList.add(item)
            }
        }
        notifyDataSetChanged()
    }

    class ViewHolder (itemview : View): RecyclerView.ViewHolder(itemview){
        val imageview: ImageView = itemView.findViewById(R.id.deleteImg)
        val name: TextView = itemView.findViewById(R.id.dealerName)

    }


}