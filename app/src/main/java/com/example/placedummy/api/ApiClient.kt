package com.example.enotes.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val BASEURL ="http://syedbrothers.tech/api/"

object ApiClient {

    fun getRetrofit(): Retrofit {

        val logger = HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BASIC)

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .client(client)
            .build()

        return retrofit

    }

    fun getApiService(): ApiServices{
        return getRetrofit().create(ApiServices::class.java)
    }



}