package com.jedsada.workshopkoltincnx.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.jedsada.workshopkoltincnx.loadImage
import com.jedsada.workshopkoltincnx.model.MovieDetailModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.*

class MovieViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun onBindData(movieDetailModel: MovieDetailModel?) {
        tv_name.text = movieDetailModel?.title
        tv_des.text = movieDetailModel?.overview
        img_cover loadImage movieDetailModel?.imageUrl
    }
}