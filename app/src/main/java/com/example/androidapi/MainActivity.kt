package com.example.androidapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapi.network.configuration.EventsInterface
import com.example.androidapi.network.configuration.RetrofitConfiguration
import com.example.androidapi.network.configuration.model.FilmesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val urlBasic = "http://www.omdbapi.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getFilmes()


    }
    fun getFilmes() {
        val retrofitClient = RetrofitConfiguration.getRetrofitIntance(urlBasic)
        val interfaceGet = retrofitClient.create(EventsInterface::class.java)
        val callBack = interfaceGet.getFilmes()

        callBack.enqueue(object: Callback<FilmesResponse> {
            override fun onFailure(call: Call<FilmesResponse>, t: Throwable) {
                val error = t.message

            }
            override fun onResponse(call: Call<FilmesResponse>, response: Response<FilmesResponse>) {
                response.body()

            }
        })
    }
}