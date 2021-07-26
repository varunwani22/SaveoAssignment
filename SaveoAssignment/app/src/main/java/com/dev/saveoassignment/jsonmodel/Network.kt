package com.dev.saveoassignment.jsonmodel


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("country")
    var country: Country,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)