package com.example.placedummy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R

class FavoriteAdapter(context: Context): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.favourite_item_view,parent,false)
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


    class ViewHolder (itemview :View): RecyclerView.ViewHolder(itemview){
        val cardView: CardView = itemview.findViewById(R.id.fav_cardview1)
        val favImg: ImageView = itemView.findViewById(R.id.fav_imageView)
        val fav_name: TextView = itemView.findViewById(R.id.fav_name)
        val fav_rating: TextView = itemView.findViewById(R.id.fav_rating)
        val fav_loc: TextView = itemView.findViewById(R.id.fav_location)
        val fav_price: TextView = itemView.findViewById(R.id.fav_price)
        val fav_priceby: TextView = itemView.findViewById(R.id.fav_priceby)


    }

}