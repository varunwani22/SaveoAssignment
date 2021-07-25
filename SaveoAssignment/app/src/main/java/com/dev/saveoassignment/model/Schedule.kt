package com.dev.saveoassignment.model


import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("days")
    var days: List<String>,
    @SerializedName("time")
    var time: String
)