package com.example.placedummy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class Pie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie)
//
//        //Create a dataset
//        val dataArray = ArrayList<PieEntry>()
//        dataArray.add(PieEntry(38f))
//        dataArray.add(PieEntry(14f))
//        dataArray.add(PieEntry(14f))
//        dataArray.add(PieEntry(34f))
//        val dataSet = PieDataSet(dataArray, "")
//        dataSet.valueTextSize=20f
//        dataSet.valueTextColor=Color.WHITE
//
//        //Color set for the chart
//        val colorSet = java.util.ArrayList<Int>()
//        colorSet.add(Color.rgb(255,107,107))  //red
//        colorSet.add(Color.rgb(173,232,244))  // blue
//        colorSet.add(Color.rgb(216,243,220))  // green
//        colorSet.add(Color.rgb(255,230,109))  // Yellow
//        dataSet.setColors(colorSet)
//
//        val data = PieData(dataSet)
//
//        //chart description
//        pieChart.description.text = "Pie chart"
//        pieChart.description.textSize = 20f
//
//        //Chart data and other styling
//        pieChart.data = data
//        pieChart.centerTextRadiusPercent = 0f
//        pieChart.isDrawHoleEnabled = true
//        pieChart.legend.isEnabled = false
//        pieChart.description.isEnabled = true
//
//        val yVals = ArrayList<PieEntry>()
//
//        yVals.add(PieEntry(30f))
//        yVals.add(PieEntry(2f))
//        yVals.add(PieEntry(4f))
//        yVals.add(PieEntry(22f))
//        yVals.add(PieEntry(12.5f))
//
//        val dataSet = PieDataSet(yVals, "")
//        dataSet.valueTextSize=0f
//        val colors = java.util.ArrayList<Int>()
//        colors.add(Color.GRAY)
//        colors.add(Color.BLUE)
//        colors.add(Color.RED)
//        colors.add(Color.GREEN)
//        colors.add(Color.MAGENTA)
//
//        dataSet.setColors(colors)
//        val data = PieData(dataSet)
//        pieChart.data = data
//        pieChart.centerTextRadiusPercent = 0f
//        pieChart.isDrawHoleEnabled = false
//        pieChart.legend.isEnabled = false
//        pieChart.description.isEnabled = false

    }
}