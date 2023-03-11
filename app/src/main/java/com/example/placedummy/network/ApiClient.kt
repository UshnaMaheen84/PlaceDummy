package com.example.placedummy.network

import com.example.placedummy.api.ApiInterface
import com.example.placedummy.api.ApiServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class ApiClient {
    object MyClientSingleton {
        const val BASEURL ="http://syedbrothers.tech/api/"
        fun getClient(): ApiServices {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val builder: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(object :
                Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    val newRequest: Request = chain.request().newBuilder()
                        .addHeader("Connection","Close")
                        .build()
                    return chain.proceed(newRequest)
                }
            })
            builder.readTimeout(35, TimeUnit.SECONDS)
            builder.retryOnConnectionFailure(true)
            builder.connectTimeout(35, TimeUnit.SECONDS)
            builder.writeTimeout(35, TimeUnit.SECONDS)
            builder.addInterceptor(interceptor)
            val client = builder.build()
            var retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASEURL)
                .build()
            return retrofit.create(ApiServices::class.java)
        }
    }
}