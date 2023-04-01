package com.example.placedummy.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.placedummy.BrowseProperties


class HomeFragment : Fragment() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           }
    }

    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(com.example.placedummy.R.layout.fragment_home, null)

        ui()
        val card_plots= view.findViewById<CardView>(com.example.placedummy.R.id.cv_plots)
        val card_shops= view.findViewById<CardView>(com.example.placedummy.R.id.cv_shops)
        val card_villas= view.findViewById<CardView>(com.example.placedummy.R.id.cv_villas)
        val card_apartment= view.findViewById<CardView>(com.example.placedummy.R.id.cv_apartments)

        val gridcategory= view.findViewById<GridLayout>(com.example.placedummy.R.id.grid_category)
        val btn_category= view.findViewById<Button>(com.example.placedummy.R.id.btn_category)

        val gridproject= view.findViewById<GridLayout>(com.example.placedummy.R.id.grid_project)
        val btn_project= view.findViewById<Button>(com.example.placedummy.R.id.btn_project)

        val btn_budget= view.findViewById<Button>(com.example.placedummy.R.id.btn_budget)
        val layout_budget= view.findViewById<LinearLayout>(com.example.placedummy.R.id.budget_layout)

        val btn_any= view.findViewById<Button>(com.example.placedummy.R.id.btn_any)
        val btn_monthly= view.findViewById<Button>(com.example.placedummy.R.id.btn_monthly)
        val btn_annually= view.findViewById<Button>(com.example.placedummy.R.id.btn_annually)


        card_plots.setOnClickListener {
            val intent = Intent(activity, BrowseProperties::class.java)
            intent.putExtra("browse","plots")
            startActivity(intent)

        }
        card_shops.setOnClickListener {
            val intent = Intent(activity, BrowseProperties::class.java)
            intent.putExtra("browse","shops")
            startActivity(intent)

        }
        card_apartment.setOnClickListener {
            val intent = Intent(activity, BrowseProperties::class.java)
            intent.putExtra("browse","apartments")
            startActivity(intent)

        }
        card_villas.setOnClickListener {
            val intent = Intent(activity, BrowseProperties::class.java)
            intent.putExtra("browse","villas")
            startActivity(intent)

        }










        btn_category.setOnClickListener {

            gridcategory.visibility = View.VISIBLE
            gridproject.visibility = View.GONE
            layout_budget.visibility = View.GONE

            btn_category.setBackgroundResource(com.example.placedummy.R.drawable.button_background)
            btn_project.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)
            btn_budget.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)

            btn_category.setTextColor(Color.WHITE)
            btn_project.setTextColor(Color.BLACK)
            btn_budget.setTextColor(Color.BLACK)


        }

        btn_budget.setOnClickListener {

            layout_budget.visibility = View.VISIBLE
            gridcategory.visibility = View.GONE
            gridproject.visibility = View.GONE

            btn_budget.setBackgroundResource(com.example.placedummy.R.drawable.button_background)
            btn_category.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)
            btn_project.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)

            btn_budget.setTextColor(Color.WHITE)
            btn_category.setTextColor(Color.BLACK)
            btn_project.setTextColor(Color.BLACK)


        }

        btn_project.setOnClickListener {

            gridproject.visibility = View.VISIBLE
            gridcategory.visibility = View.GONE
            layout_budget.visibility = View.GONE

            btn_project.setBackgroundResource(com.example.placedummy.R.drawable.button_background)
            btn_category.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)
            btn_budget.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)

            btn_project.setTextColor(Color.WHITE)
            btn_category.setTextColor(Color.BLACK)
            btn_budget.setTextColor(Color.BLACK)

        }

        btn_any.setOnClickListener {

            btn_any.setBackgroundResource(com.example.placedummy.R.drawable.button_background)
            btn_monthly.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)
            btn_annually.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)

            btn_any.setTextColor(Color.WHITE)
            btn_monthly.setTextColor(Color.BLACK)
            btn_annually.setTextColor(Color.BLACK)

        }

        btn_monthly.setOnClickListener {

            btn_monthly.setBackgroundResource(com.example.placedummy.R.drawable.button_background)
            btn_any.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)
            btn_annually.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)

            btn_any.setTextColor(Color.BLACK)
            btn_monthly.setTextColor(Color.WHITE)
            btn_annually.setTextColor(Color.BLACK)

        }

        btn_annually.setOnClickListener {

            btn_monthly.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)
            btn_any.setBackgroundResource(com.example.placedummy.R.drawable.btn_bg_selector)
            btn_annually.setBackgroundResource(com.example.placedummy.R.drawable.button_background)

            btn_any.setTextColor(Color.BLACK)
            btn_monthly.setTextColor(Color.BLACK)
            btn_annually.setTextColor(Color.WHITE)

        }

        return view

    }

    private fun ui() {

    }

}