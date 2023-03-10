package com.example.placedummy.api

import android.database.Observable
import com.example.placedummy.model.Dealer
import com.example.placedummy.model.Item
import com.google.gson.JsonElement
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
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