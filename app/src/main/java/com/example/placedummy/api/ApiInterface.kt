package com.example.placedummy.api

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {


    @POST("Dealer/DealerLogin")
    fun getData(@Body hashmao:HashMap<String,String>) : Call<JsonElement>

    @GET("Dealer/DealerLogin")
    fun getDealer(): Call<JsonElement>


    @GET("City")
    fun getCity():Call<JsonElement>
}