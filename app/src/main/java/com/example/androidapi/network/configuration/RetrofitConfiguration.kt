package com.example.androidapi.network.configuration

import android.icu.util.TimeUnit
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitConfiguration {
    fun getRetrofitIntance(path: String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(path)
            .client(okHttpClient().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun okHttpClient() = OkHttpClient().newBuilder()
        .addInterceptor(
            Interceptor { chain ->
                val request: Request = chain.request()
                    .newBuilder()
                    .addHeader("accept", "application/json")
                    .addHeader(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkMTY5ZTY0NGYxZTc4ZjgyMDZlYzUzNmMzNjUyYWE5MCIsIm5iZiI6MTczNjI2NjUyNC4yLCJzdWIiOiI2NzdkNTMxY2NmNGQ1OWM4NGY3Mjg1ZjgiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.EFvAG5OPg_ZNVuA9bHUTj_MgHafjfDnCzfjmQGiocgA"
                    )
                    .build()
                chain.proceed(request)
            })

    //val service: EventsInterface = getRetrofitIntance().create(EventsInterface::class.java)

}