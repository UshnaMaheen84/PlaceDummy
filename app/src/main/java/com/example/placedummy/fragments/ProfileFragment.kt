package com.example.placedummy.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.placedummy.R
import com.example.placedummy.databinding.FragmentProfileBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


class ProfileFragment : Fragment() {

//    private var chart: pieChart2? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProfileBinding.inflate(inflater,container,false)


        try {
            setUpSelectionpieChart2()
        } catch (e: Exception) {
            Log.e("log8", e.toString()  )
        }
        return binding.root
    }



    private fun setUpSelectionpieChart2() {

        //Create a dataset
        val dataArray = ArrayList<PieEntry>()
        dataArray.add(PieEntry(38f))
        dataArray.add(PieEntry(14f))
        dataArray.add(PieEntry(14f))
        dataArray.add(PieEntry(34f))
        val dataSet = PieDataSet(dataArray, "")
        dataSet.valueTextSize=20f
        dataSet.valueTextColor=Color.WHITE

        //Color set for the chart
        val colorSet = java.util.ArrayList<Int>()
        colorSet.add(Color.rgb(255,107,107))  //red
        colorSet.add(Color.rgb(173,232,244))  // blue
        colorSet.add(Color.rgb(216,243,220))  // green
        colorSet.add(Color.rgb(255,230,109))  // Yellow
        dataSet.setColors(colorSet)

        val data = PieData(dataSet)

        //chart description
        binding.pieChart2.description.text = "Pie chart"
        binding.pieChart2.description.textSize = 20f

        //Chart data and other styling
        binding.pieChart2.data = data
        binding.pieChart2.centerTextRadiusPercent = 0f
        binding.pieChart2.isDrawHoleEnabled = true
        binding.pieChart2.legend.isEnabled = false
        binding.pieChart2.description.isEnabled = true



    }

}