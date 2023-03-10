package com.example.placedummy.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R
import com.example.placedummy.adapter.DealerAdapter
import com.example.placedummy.api.ApiInterface
import com.example.placedummy.model.Dealer
import kotlinx.android.synthetic.main.fragment_dealer.*
import kotlinx.android.synthetic.main.fragment_favourite.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

 const val BASEURL ="http://syedbrothers.tech/api/"
class DealerFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            }
    }
    lateinit var adapter: DealerAdapter
    lateinit var recyclerView:RecyclerView
    lateinit var tv :TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dealer, null)

         recyclerView= view.findViewById(R.id.dealer_recyclerview)
        adapter= DealerAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter= adapter
        recyclerView.layoutManager= LinearLayoutManager(context)

        dealerSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null){
                              adapter.filterlist(newText)
                }
                return true            }
        })



        tv= view.findViewById(R.id.check)


        Log.e("log1","working")
       getData()

        return view
    }

    private fun getData() {
        Log.e("log2","working")
        val retrofitbuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitdata= retrofitbuilder.getDealer()
        Log.e("log3","working")


        retrofitdata.enqueue(object : Callback<ArrayList<Dealer>> {

            override fun onResponse(call: Call<ArrayList<Dealer>>, response: Response<ArrayList<Dealer>>) {
                Log.e("log4",response.toString())

                val responseBody= response.body()!!

                tv.text= responseBody.toString()
                Log.e("log5",responseBody.toString())


                adapter= DealerAdapter()
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter= adapter
                recyclerView.layoutManager= LinearLayoutManager(context)

            }

            override fun onFailure(call: Call<ArrayList<Dealer>>, t: Throwable) {
                Log.e("log6",t.message.toString())

            }
        })

       }

}