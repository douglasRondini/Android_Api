package com.example.androidapi.model

import com.google.gson.annotations.SerializedName

data class FilmesResponse(
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String
)
