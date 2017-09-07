package com.jedsada.workshopkoltincnx.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.jedsada.workshopkoltincnx.R
import com.jedsada.workshopkoltincnx.hide
import com.jedsada.workshopkoltincnx.model.MovieModel
import com.jedsada.workshopkoltincnx.navigate
import com.jedsada.workshopkoltincnx.repository.MovieRepository
import com.jedsada.workshopkoltincnx.ui.details.DetailActivity
import com.jedsada.workshopkoltincnx.ui.main.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MainView, AppCompatActivity() {

    private val movieAdapter: MovieAdapter by lazy { MovieAdapter() }
    private val mainController: MainController by lazy { MainController(this, MovieRepository()) }
    private val KEY_MODEL_MOVIE = "model_movie"
    private var movieModel: MovieModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        if (savedInstanceState == null) initialize()
    }

    private fun setupView() {
        movieAdapter.apply {
            movieItemOnClick = {
                Log.d("POND", it.toString())
                navigate<DetailActivity> { putExtra(DetailActivity.KEY_DETAILS_MOVIE, it) }
            }
        }
        list_movie?.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }

    private fun initialize() {
        mainController.loadMovie()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(KEY_MODEL_MOVIE, movieModel)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        movieModel = savedInstanceState?.getParcelable(KEY_MODEL_MOVIE)
        movieModel?.listMovie?.run {
            hideDialog()
            movieAdapter.items = this
        } ?: initialize()
    }

    override fun setMovieData(movieModel: MovieModel?) {
        this.movieModel = movieModel
        movieAdapter.items = movieModel?.listMovie ?: listOf()
    }

    override fun setMessageError(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun hideDialog() = loading.hide()
}