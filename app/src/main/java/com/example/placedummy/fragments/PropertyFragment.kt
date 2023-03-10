package com.example.placedummy.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.placedummy.R

class PropertyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(com.example.placedummy.R.layout.fragment_property, null)

        val text_hold= view.findViewById<TextView>(com.example.placedummy.R.id.text_hold)
        val text_sold= view.findViewById<TextView>(com.example.placedummy.R.id.text_sold)

        text_hold.setOnClickListener {

            text_hold.setBackgroundResource(com.example.placedummy.R.drawable.button_background)
            text_sold.setBackgroundColor(Color.WHITE)

            text_hold.setTextColor(Color.WHITE)
            text_sold.setTextColor(Color.BLACK)

        }

        text_sold.setOnClickListener {

            text_sold.setBackgroundResource(com.example.placedummy.R.drawable.button_background)
            text_hold.setBackgroundColor(Color.WHITE)

            text_sold.setTextColor(Color.WHITE)
            text_hold.setTextColor(Color.BLACK)

        }
        return view
    }

}