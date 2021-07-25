package com.dev.saveoassignment.model


import com.google.gson.annotations.SerializedName

data class ResponseModelItem(
    @SerializedName("score")
    var score: Double,
    @SerializedName("show")
    var show: Show
)