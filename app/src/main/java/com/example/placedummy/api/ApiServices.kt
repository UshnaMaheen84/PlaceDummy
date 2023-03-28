package com.example.placedummy.api


import com.example.placedummy.model.*
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiServices {

    @POST("Users/LoginUsers")
    fun loginUser(@Body loginRequest: UserLogin): Call<UserLogin>

    @POST("Users/PostUsers")
    fun registerUser(@Body registerRequest: User): Call<User>

    @POST("Dealer/DealerLogin")
    fun dealerLogin(@Body loginRequest: DealerRequestLogin): Call<String>

    @GET("Dealer")
    fun getDealers() : Call<DealerModel>

    @POST("Dealer/DealerLogin")
    fun getData(@Body hashmao:HashMap<String,String>) : Call<JsonElement>

    @POST("Dealer/DealerLogin")
    fun getData2(@Body hashmao:HashMap<String,String>) :Call<String>

    @PUT("Dealer/AddDealerData")
    fun addDealerData(@Body addOrUpdateDealerData: AddDealerData) :Call<Int>
}