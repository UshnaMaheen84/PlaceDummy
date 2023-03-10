package com.example.placedummy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.placedummy.R
import com.example.placedummy.adapter.DealerAdapter
import com.example.placedummy.adapter.FavoriteAdapter
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
         }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(com.example.placedummy.R.layout.fragment_favourite, null)


         adapter= FavoriteAdapter()

        fav_rview.setHasFixedSize(true)
        fav_rview.layoutManager= LinearLayoutManager(context)
        fav_rview.adapter= adapter


        fav_searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null){
          //          adapter.filterlist(newText)
                }
                return true            }
        })
        return view
    }

}