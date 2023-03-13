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
import com.example.placedummy.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
         }
    }
    lateinit var binding: FragmentFavouriteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(com.example.placedummy.R.layout.fragment_favourite, null)

        binding= FragmentFavouriteBinding.inflate(inflater,container,false)

         adapter= FavoriteAdapter()

        binding.favRview.setHasFixedSize(true)
        binding.favRview.layoutManager= LinearLayoutManager(context)
        binding.favRview.adapter= adapter


        binding.favSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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