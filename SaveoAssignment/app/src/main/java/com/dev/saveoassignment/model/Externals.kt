package com.dev.saveoassignment.model


import com.google.gson.annotations.SerializedName

data class Externals(
    @SerializedName("imdb")
    var imdb: String,
    @SerializedName("thetvdb")
    var thetvdb: Int,
    @SerializedName("tvrage")
    var tvrage: Any
)