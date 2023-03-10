package com.example.placedummy.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R
import com.example.placedummy.adapter.DealerAdapter
import com.example.placedummy.api.ApiInterface
import com.example.placedummy.model.Dealer
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DealerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
 const val BASEURL ="http://syedbrothers.tech/api/"
class DealerFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            }
    }
    lateinit var dealer_adapter: DealerAdapter
    lateinit var recyclerView:RecyclerView
    lateinit var tv :TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dealer, null)

         recyclerView= view.findViewById(R.id.dealer_recyclerview)

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


        retrofitdata.enqueue(object : Callback<List<Dealer>> {

            override fun onResponse(call: Call<List<Dealer>>, response: Response<List<Dealer>>) {
                Log.e("log4",response.toString())

                val responseBody= response.body()!!

                tv.text= responseBody.toString()
                Log.e("log5",responseBody.toString())


                //   val dealerAdapter= getContext()?.let { DealerAdapter(it,responseBody) }


                dealer_adapter= DealerAdapter(responseBody)
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter= dealer_adapter
                recyclerView.layoutManager= LinearLayoutManager(context)

            }

            override fun onFailure(call: Call<List<Dealer>>, t: Throwable) {
                Log.e("log6",t.message.toString())

            }
        })

       }

}