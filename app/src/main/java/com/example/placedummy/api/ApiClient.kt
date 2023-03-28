package com.example.enotes.api

import com.example.placedummy.api.ApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

    const val BASEURL ="http://api.jinnahbuildersandrealestate.com/api/"

object ApiClient {

    fun getRetrofit(): Retrofit {

        val logger = HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BASIC)

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BASEURL)
            .client(client)
            .build()

        return retrofit

    }


    fun getUshnaEndPointService():ApiServices{
        return getRetrofit().create(ApiServices::class.java)
    }

    fun getApiService(): ApiServices {
        return getRetrofit().create(ApiServices::class.java)
    }



}