package com.example.enotes.api


import com.example.placedummy.model.User
import com.example.placedummy.model.UserLogin
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {

    @POST("Users/LoginUsers")
    fun loginUser(@Body loginRequest: UserLogin): Call<UserLogin>

    @POST("Users/PostUsers")
    fun registerUser(@Body registerRequest: User): Call<User>


}