package com.jedsada.workshopkoltincnx.ui.main

import com.jedsada.workshopkoltincnx.model.MovieModel

interface MainView {
    fun hideDialog()
    fun setMovieData(movieModel: MovieModel?)
    fun setMessageError(message: String)
}