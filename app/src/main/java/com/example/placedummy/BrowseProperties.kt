package com.example.placedummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.placedummy.adapter.ProjectDetailsAdapter
import com.example.placedummy.databinding.ActivityBrowsePropertiesBinding
import com.example.placedummy.model.forProject.Project
import com.example.placedummy.model.forProject.ProjectX
import com.example.placedummy.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrowseProperties : AppCompatActivity() {

    lateinit var binding: ActivityBrowsePropertiesBinding

    lateinit var adapter:ProjectDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBrowsePropertiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tilte = intent.extras!!.getString("browse")
        if (tilte.equals("plots")){
            getPlot()
        }

        if (tilte.equals("shops")){
            getShop()
        }

        if (tilte.equals("villas")){
            getVilla()
        }

        if (tilte.equals("apartments")){
            getApartment()
        }



    }

    private fun getApartment() {


//        "propertyTypeId": 2,
//        "type": "Apartments",
        val call = ApiClient.MyClientSingleton.getClient().getProjects()
        call.enqueue(object : Callback<Project> {
            override fun onResponse(call: Call<Project>, response: Response<Project>) {
                if (response.isSuccessful) {
                    val list = response.body()!!.projects

                    adapter = ProjectDetailsAdapter(list)

                    binding.browseRview.layoutManager = LinearLayoutManager(this@BrowseProperties)
                    binding.browseRview.setHasFixedSize(true)
                    binding.browseRview.adapter = adapter


                } else {
                    Toast.makeText(this@BrowseProperties, response.message(), Toast.LENGTH_LONG).show()
                    Log.e("failureError", response.message())
                }
            }

            override fun onFailure(call: Call<Project>, t: Throwable) {
                Toast.makeText(this@BrowseProperties, t.message, Toast.LENGTH_LONG).show()
                Log.e("failureErrorException", t.message!!)
            }

        })

    }

    private fun getVilla() {
        TODO("Not yet implemented")
    }

    private fun getShop() {
        TODO("Not yet implemented")
    }

    private fun getPlot() {
        TODO("Not yet implemented")
    }
}