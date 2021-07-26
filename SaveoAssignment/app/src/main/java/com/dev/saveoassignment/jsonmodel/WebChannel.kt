package com.dev.saveoassignment.jsonmodel


import com.google.gson.annotations.SerializedName

data class WebChannel(
    @SerializedName("country")
    var country: Any,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)