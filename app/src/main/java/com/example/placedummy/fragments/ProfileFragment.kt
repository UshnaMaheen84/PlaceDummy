package com.example.placedummy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.example.placedummy.R


class ProfileFragment : Fragment() {

    private var chart: AnyChartView? = null

    private val salary = listOf(200,300,400,600)
    private val month = listOf("January","February","March","April")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(com.example.placedummy.R.layout.fragment_profile, null)


        chart = view.findViewById(R.id.pieChart)

        configChartView()
        return view
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