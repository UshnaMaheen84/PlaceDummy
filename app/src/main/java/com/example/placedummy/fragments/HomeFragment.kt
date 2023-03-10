package com.example.placedummy.fragments

import android.R
import android.graphics.Color
import android.graphics.Color.DKGRAY
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Layout
import android.transition.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
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
        val view: View = inflater.inflate(com.example.placedummy.R.layout.fragment_home, null)


        val gridcategory= view.findViewById<GridLayout>(com.example.placedummy.R.id.grid_category)
        val btn_category= view.findViewById<Button>(com.example.placedummy.R.id.btn_category)

        val gridproject= view.findViewById<GridLayout>(com.example.placedummy.R.id.grid_project)
        val btn_project= view.findViewById<Button>(com.example.placedummy.R.id.btn_project)

        val btn_budget= view.findViewById<Button>(com.example.placedummy.R.id.btn_budget)
        val layout_budget= view.findViewById<LinearLayout>(com.example.placedummy.R.id.budget_layout)

        val btn_any= view.findViewById<Button>(com.example.placedummy.R.id.btn_any)
        val btn_monthly= view.findViewById<Button>(com.example.placedummy.R.id.btn_monthly)
        val btn_annually= view.findViewById<Button>(com.example.placedummy.R.id.btn_annually)


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

}