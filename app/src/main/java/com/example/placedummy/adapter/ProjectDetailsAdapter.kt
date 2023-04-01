package com.example.placedummy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R
import com.example.placedummy.model.forProject.Project
import com.example.placedummy.model.forProject.ProjectPropertyType
import com.example.placedummy.model.forProject.ProjectX

class ProjectDetailsAdapter (val list: List<ProjectX>): RecyclerView.Adapter<ProjectDetailsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_item_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item= list[position]
        holder.property_name.text= item.name
        holder.property_area.text= item.totalsize.toString()
        holder.property_loc.text= item.address





    }

    override fun getItemCount()= list.size


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