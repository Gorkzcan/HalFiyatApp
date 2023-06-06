package com.gorkem.halfiyatlar.service

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request : Request = chain.request()
            .newBuilder()
            .header("content-type", "application/json")
            .header("authorization", "apikey 2ln7wMrnDO2pvly30MRNz1:5HIfn2tsIrcNU2twEQsLjY")
            .build()
        chain.proceed(request)
    }.build()

    fun getClient(baseUrl:String): Retrofit{
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}