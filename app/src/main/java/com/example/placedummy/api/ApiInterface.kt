package com.example.placedummy.api

import android.database.Observable
import com.example.placedummy.model.Dealer
import com.example.placedummy.model.Item
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {


    @GET("Dealer/DealerLogin")
    fun getData() : Call<List<Item>>

    @GET("Dealer/DealerLogin")
    fun getDealer(): Call<List<Dealer>>
}