package com.jedsada.workshopkoltincnx.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.jedsada.workshopkoltincnx.R
import com.jedsada.workshopkoltincnx.inflate
import com.jedsada.workshopkoltincnx.model.MovieDetailModel
import kotlin.properties.Delegates

typealias MovieItemOnclick = (MovieDetailModel) -> Unit

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    var movieItemOnClick: MovieItemOnclick? = null

    var items: List<MovieDetailModel>  by Delegates.observable(listOf(), { property, oldValue, newValue ->
        Log.d("property", property.toString())
        Log.d("oldValue", oldValue.toString())
        Log.d("newValue", newValue.toString())
        notifyDataSetChanged()
    })

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {
        holder?.onBindData(items[position])
        holder?.itemView?.setOnClickListener { movieItemOnClick?.invoke(items[position]) }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder =
            MovieViewHolder(parent?.inflate(R.layout.item_movie))

    override fun getItemCount(): Int = items.size
}