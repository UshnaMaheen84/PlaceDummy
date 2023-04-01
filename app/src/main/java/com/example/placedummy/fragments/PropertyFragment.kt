package com.example.placedummy.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.placedummy.R
import com.example.placedummy.adapter.DealerAdapter
import com.example.placedummy.adapter.ProjectDetailsAdapter
import com.example.placedummy.databinding.FragmentDealerBinding
import com.example.placedummy.databinding.FragmentPropertyBinding
import com.example.placedummy.model.DealerModel
import com.example.placedummy.model.forProject.Project
import com.example.placedummy.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PropertyFragment : Fragment() {

    lateinit var binding: FragmentPropertyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    lateinit var adapter:ProjectDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPropertyBinding.inflate(inflater, container, false)

        binding.textHold.setOnClickListener {

            binding.textHold.setBackgroundResource(R.drawable.button_background)
            binding.textSold.setBackgroundColor(Color.WHITE)

            binding.textHold.setTextColor(Color.WHITE)
            binding.textSold.setTextColor(Color.BLACK)

        }

        binding.textSold.setOnClickListener {

            binding.textSold.setBackgroundResource(R.drawable.button_background)
            binding.textHold.setBackgroundColor(Color.WHITE)

            binding.textSold.setTextColor(Color.WHITE)
            binding.textHold.setTextColor(Color.BLACK)

        }

        getProjects()

        return binding.root
    }

    private fun getProjects() {

        val call = ApiClient.MyClientSingleton.getClient().getProjects()
        call.enqueue(object : Callback<Project> {
            override fun onResponse(call: Call<Project>, response: Response<Project>) {
                if (response.isSuccessful) {
                    val list = response.body()!!.projects

                    adapter = ProjectDetailsAdapter(list)

                    binding.recyclerProjects.layoutManager = LinearLayoutManager(context)
                    binding.recyclerProjects.setHasFixedSize(true)
                    binding.recyclerProjects.adapter = adapter


                } else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_LONG).show()
                    Log.e("failureError", response.message())
                }
            }

            override fun onFailure(call: Call<Project>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                Log.e("failureErrorException", t.message!!)
            }

        })

    }

}