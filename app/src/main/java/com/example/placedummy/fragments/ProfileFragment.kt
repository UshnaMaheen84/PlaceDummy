package com.example.placedummy.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.placedummy.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

//    private var chart: PieChart? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed(Runnable {
            setUpSelectionPieChart()
        },1000)
    }

    private fun setUpSelectionPieChart() {

        //Create a dataset
        val dataArray = ArrayList<PieEntry>()
        dataArray.add(PieEntry(38f))
        dataArray.add(PieEntry(14f))
        dataArray.add(PieEntry(14f))
        dataArray.add(PieEntry(34f))
        val dataSet = PieDataSet(dataArray, "")
        dataSet.valueTextSize=20f
        dataSet.valueTextColor= Color.WHITE

        //Color set for the chart
        val colorSet = java.util.ArrayList<Int>()
        colorSet.add(Color.rgb(255,107,107))  //red
        colorSet.add(Color.rgb(173,232,244))  // blue
        colorSet.add(Color.rgb(216,243,220))  // green
        colorSet.add(Color.rgb(255,230,109))  // Yellow
        dataSet.setColors(colorSet)
        pie_chart.description.text = "Pie chart"
        pie_chart.description.textSize = 20f

        //Chart data and other styling
        pie_chart.centerTextRadiusPercent = 0f
        pie_chart.isDrawHoleEnabled = true
        pie_chart.legend.isEnabled = false
        pie_chart.description.isEnabled = true
        val data = PieData(dataSet)
        pie_chart.data = data

        //chart description



    }

}