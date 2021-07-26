package com.dev.saveoassignment.jsonmodel


import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("days")
    var days: List<String>,
    @SerializedName("time")
    var time: String
)