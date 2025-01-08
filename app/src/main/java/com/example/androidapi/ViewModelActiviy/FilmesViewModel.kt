package com.example.androidapi.ViewModelActiviy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidapi.network.configuration.EventsInterface
import com.example.androidapi.network.configuration.RetrofitConfiguration
import com.example.androidapi.model.ListaFilmesDbResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmesViewModel: ViewModel() {

    private val _filmes = MutableLiveData<ListaFilmesDbResponse>()

    val filmes: LiveData<ListaFilmesDbResponse>get() = _filmes

    fun getFilmes(urls: String) {
        val retrofitClient = RetrofitConfiguration.getRetrofitIntance(urls)
        val interfaceGet = retrofitClient.create(EventsInterface::class.java)
        val callBack = interfaceGet.getFilmeDb()

        callBack.enqueue(object: Callback<ListaFilmesDbResponse> {
            override fun onFailure(call: Call<ListaFilmesDbResponse>, t: Throwable) {
                val error = t.message

            }
            override fun onResponse(
                call: Call<ListaFilmesDbResponse>,
                response: Response<ListaFilmesDbResponse>
            ) {
                _filmes.value = response.body()
            }

        })



    }

}