package com.example.androidapi.network.configuration.ViewModelActiviy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidapi.network.configuration.EventsInterface
import com.example.androidapi.network.configuration.RetrofitConfiguration
import com.example.androidapi.network.configuration.model.FilmesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmesViewModel: ViewModel() {

    private val _filmes = MutableLiveData<String>()

    val filmes: LiveData<String>get() = _filmes

    fun getFilmes(urlBasic: String) {
        val retrofitClient = RetrofitConfiguration.getRetrofitIntance(urlBasic)
        val interfaceGet = retrofitClient.create(EventsInterface::class.java)
        val callBack = interfaceGet.getFilmes()

        callBack.enqueue(object: Callback<FilmesResponse> {
            override fun onFailure(call: Call<FilmesResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<FilmesResponse>, response: Response<FilmesResponse>) {
                response.body()?.let {
                    _filmes.value = it.toString()
                }


            }

        })

    }

}