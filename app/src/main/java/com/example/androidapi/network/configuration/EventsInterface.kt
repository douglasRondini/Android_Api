package com.example.androidapi.network.configuration

import com.example.androidapi.model.FilmesResponse
import com.example.androidapi.model.ListaFilmesDbResponse
import retrofit2.Call
import retrofit2.http.GET
val key = "b206ed14"

interface EventsInterface {
    @GET("/?apikey=b206ed14&t=homen&plot=full")
    fun getFilmes(): Call<FilmesResponse>

    @GET("/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
    fun getFilmeDb() :Call<ListaFilmesDbResponse>
}