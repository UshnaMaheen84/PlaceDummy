package com.example.placedummy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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
        val cardView: CardView= itemview.findViewById(R.id.property_cardview1)
        val propertyImg: ImageView = itemView.findViewById(R.id.property_imageView)
       val favorite: ImageView = itemView.findViewById(R.id.favorite)
        val property_name: TextView = itemView.findViewById(R.id.property_name)
      val property_rating: TextView = itemView.findViewById(R.id.property_ratings)
      val property_loc: TextView = itemView.findViewById(R.id.property_location)
      val property_rooms: TextView = itemView.findViewById(R.id.rooms)
      val property_area: TextView = itemView.findViewById(R.id.area)
      val property_price: TextView = itemView.findViewById(R.id.price)
      val property_priceby: TextView = itemView.findViewById(R.id.price_by)


    }
}