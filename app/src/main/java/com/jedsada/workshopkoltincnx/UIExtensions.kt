package com.jedsada.workshopkoltincnx

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

infix fun ImageView.loadImage(url: String?): Target<Drawable> = let {
    val requestOptions = RequestOptions().format(DecodeFormat.PREFER_ARGB_8888)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(android.R.color.darker_gray)
            .placeholder(android.R.color.darker_gray)
    Glide.with(this).setDefaultRequestOptions(requestOptions).load(url).into(this)
}

fun View.hide() = let { visibility = View.GONE }

inline fun <reified A : Activity> Activity.naviagate(func: Intent.() -> Unit) {
    val intent = Intent(this, A::class.java)
    intent.func()
    startActivity(intent)
}
