package com.example.placedummy.fragments

import android.R
import android.graphics.Color
import android.graphics.Color.DKGRAY
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


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        val category= view.findViewById<Button>(com.example.placedummy.R.id.text_category)
        val layout_category= view.findViewById<LinearLayout>(com.example.placedummy.R.id.layout_category)

        val gridproject= view.findViewById<GridLayout>(com.example.placedummy.R.id.grid_project)
        val project= view.findViewById<Button>(com.example.placedummy.R.id.text_project)
        val layout_project= view.findViewById<LinearLayout>(com.example.placedummy.R.id.layout_project)

        category.setOnClickListener {
            category.setTextColor(Color.WHITE)
            project.setTextColor(Color.BLACK)
            gridcategory.visibility = View.VISIBLE
            gridproject.visibility = View.GONE
            layout_category.isPressed
            !layout_project.isPressed


        }
        project.setOnClickListener {
            category.setTextColor(Color.BLACK)
            project.setTextColor(Color.WHITE)

            gridproject.visibility = View.VISIBLE
            gridcategory.visibility = View.GONE

            layout_category.isPressed=false
            layout_project.isPressed=true
        }
        return view

    }

}