package com.example.androidapi

import com.example.androidapi.Uteis.Urlls
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.androidapi.ViewModelActiviy.FilmesViewModel
import com.example.androidapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val urls = Urlls
    private val filmesViewModel: FilmesViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        filmesViewModel.filmes.observe(this, Observer { filmes ->

        })

        filmesViewModel.getFilmes(urls.urlBasicDb)

    }



}