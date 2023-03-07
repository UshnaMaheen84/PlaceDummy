package com.example.placedummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry

class Pie : AppCompatActivity() {
    private var chart: AnyChartView? = null

    private val salary = listOf(200,300,400,600)
    private val month = listOf("January","February","March","April")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie)

        chart = findViewById(R.id.pieChart)

        configChartView()
    }

    private fun configChartView() {
        val pie : com.anychart.charts.Pie = AnyChart.pie()

        val dataPieChart: MutableList<DataEntry> = mutableListOf()

        for (index in salary.indices){
            dataPieChart.add(ValueDataEntry(month.elementAt(index),salary.elementAt(index)))
        }

        pie.data(dataPieChart)
        pie.title("Salaries Overview")
        chart!!.setChart(pie)

    }
}