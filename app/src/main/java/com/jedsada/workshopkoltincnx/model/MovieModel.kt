package com.jedsada.workshopkoltincnx.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel(Parcel.Serialization.BEAN)
data class MovieModel(@SerializedName("results") val listMovie: List<MovieDetailModel>? = listOf())

@Parcel(Parcel.Serialization.BEAN)
data class MovieDetailModel(@SerializedName("title") val title: String? = null,
                            @SerializedName("image_url") val imageUrl: String? = null,
                            @SerializedName("overview") val overview: String? = null)