package com.dev.saveoassignment.jsonmodel


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    var average: Double
)