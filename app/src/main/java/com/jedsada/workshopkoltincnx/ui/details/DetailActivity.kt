package com.jedsada.workshopkoltincnx.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jedsada.workshopkoltincnx.R
import com.jedsada.workshopkoltincnx.loadImage
import com.jedsada.workshopkoltincnx.model.MovieDetailModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_MOVIE_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tv_name.text = extractDataFromIntent()?.title
        tv_des.text = extractDataFromIntent()?.overview
        img_cover loadImage extractDataFromIntent()?.title
    }

    private fun extractDataFromIntent(): MovieDetailModel? = null
}