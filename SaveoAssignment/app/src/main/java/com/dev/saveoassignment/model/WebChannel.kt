package com.dev.saveoassignment.model


import com.google.gson.annotations.SerializedName

data class WebChannel(
    @SerializedName("country")
    var country: Country,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)