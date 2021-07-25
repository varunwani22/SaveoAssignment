package com.dev.saveoassignment.data

import com.dev.saveoassignment.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    /**
     * declaration of End point
     */

    @GET("search/shows")
    suspend fun getAllMovies(
        @Query("q") q: String
    ): ResponseModel
}