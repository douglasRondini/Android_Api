package com.example.androidapi.network.configuration

import android.icu.util.TimeUnit
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitConfiguration {
    fun getRetrofitIntance(path: String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //val service: EventsInterface = getRetrofitIntance().create(EventsInterface::class.java)

}