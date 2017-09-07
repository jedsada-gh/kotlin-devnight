package com.jedsada.workshopkoltincnx.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jedsada.workshopkoltincnx.R
import com.jedsada.workshopkoltincnx.loadImage
import com.jedsada.workshopkoltincnx.model.MovieDetailModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_DETAILS_MOVIE = "details_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_name.text = extractDataFromIntent()?.title
        tv_des.text = extractDataFromIntent()?.overview
        img_cover loadImage extractDataFromIntent()?.imageUrl
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun extractDataFromIntent(): MovieDetailModel? = intent.getParcelableExtra(KEY_DETAILS_MOVIE)
}