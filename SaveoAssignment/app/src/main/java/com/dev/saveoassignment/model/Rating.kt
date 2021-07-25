package com.dev.saveoassignment.model


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    var average: Double
)