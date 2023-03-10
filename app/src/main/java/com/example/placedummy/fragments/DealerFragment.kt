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
import com.example.placedummy.network.ApiClient
import com.google.gson.Gson
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.fragment_dealer.*
import kotlinx.android.synthetic.main.fragment_favourite.*
import org.json.JSONObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class DealerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    lateinit var adapter: DealerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var tv: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dealer, null)

        recyclerView = view.findViewById(R.id.dealer_recyclerview)
        adapter = DealerAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

//        dealerSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                if (newText != null){
//                              adapter.filterlist(newText)
//                }
//                return true            }
//        })


        tv = view.findViewById(R.id.check)


        Log.e("log1", "working")
        getData()

        return view
    }

    class Dealer{
        var Email:String = "usama@gmail.com"
        var Password:String = "12345"

    }

    private fun getData() {
        Log.e("log2", "working")

        var email:String = "usama@gmail.com"
        var password:String = "12345"



        var json  = HashMap<String,String>()
        json.put("Email",email)
        json.put("Password",password)


        val call = ApiClient.MyClientSingleton.getClient().getData(json)


        call.enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.e("log4", response.toString())



//                val responseBody = response.body()!!
//
//                tv.text = responseBody.toString()
//                Log.e("log5", responseBody.toString())
//
//
//                adapter = DealerAdapter()
//                recyclerView.setHasFixedSize(true)
//                recyclerView.adapter = adapter
//                recyclerView.layoutManager = LinearLayoutManager(context)
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.e("log6", t.message.toString())
            }

        })



        val callCity = ApiClient.MyClientSingleton.getClient().getCity()
        callCity.enqueue(object :Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {

            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
            }

        })


    }

}