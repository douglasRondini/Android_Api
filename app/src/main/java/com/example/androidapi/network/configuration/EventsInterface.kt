package com.example.androidapi.network.configuration

import com.example.androidapi.network.configuration.model.FilmesResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
val key = "b206ed14"

interface EventsInterface {
    @GET("/?apikey=b206ed14&t=homen&plot=full")
    fun getFilmes(): Call<FilmesResponse>
}