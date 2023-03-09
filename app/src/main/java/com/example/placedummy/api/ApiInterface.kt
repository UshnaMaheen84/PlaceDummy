package com.example.placedummy.api

import com.example.placedummy.model.Item
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {


    @GET("api/city")
    fun getData() : Call<List<Item>>

}