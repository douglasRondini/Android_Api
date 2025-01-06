package com.example.androidapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.androidapi.network.configuration.EventsInterface
import com.example.androidapi.network.configuration.RetrofitConfiguration
import com.example.androidapi.network.configuration.ViewModelActiviy.FilmesViewModel
import com.example.androidapi.network.configuration.model.FilmesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val urlBasic = "http://www.omdbapi.com"
    private val filmesViewModel: FilmesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        filmesViewModel.filmes.observe(this, Observer { filmes ->

        })

        filmesViewModel.getFilmes(urlBasic)

    }



}