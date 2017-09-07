package com.jedsada.workshopkoltincnx.repository

import com.jedsada.workshopkoltincnx.model.MovieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {
    @GET("movie")
    fun getListMovie(): Call<MovieModel>
}

class MovieRepository {

    interface MovieRepositoryCallback {
        fun onSuccess(model: MovieModel?)
        fun onError(message: String)
    }

    fun requestMovie(callback: MovieRepositoryCallback) {
        getRetrofit().create(MovieApi::class.java).getListMovie()
                .enqueue(object : Callback<MovieModel> {
                    override fun onFailure(call: Call<MovieModel>?, t: Throwable) {
                        callback.onError(t.message!!)
                    }

                    override fun onResponse(call: Call<MovieModel>?, response: Response<MovieModel>) {
                        when (response.isSuccessful) {
                            true -> callback.onSuccess(response.body())
                            else -> callback.onError(response.message())
                        }
                    }
                })
    }

    // TODO : bed code
    private fun getRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("https://workshopup.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}