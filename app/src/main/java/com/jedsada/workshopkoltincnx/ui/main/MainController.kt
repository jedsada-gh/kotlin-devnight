package com.jedsada.workshopkoltincnx.ui.main

import com.jedsada.workshopkoltincnx.model.MovieModel
import com.jedsada.workshopkoltincnx.repository.MovieRepository

class MainController(private val view: MainView?, private val movieRepository: MovieRepository) :
        MovieRepository.MovieRepositoryCallback {

    fun loadMovie() = movieRepository.requestMovie(this)

    override fun onSuccess(model: MovieModel?) {
        view?.hideDialog()
        view?.setMovieData(model)
    }

    override fun onError(message: String) {
        view?.setMessageError(message)
    }
}