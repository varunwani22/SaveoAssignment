package com.dev.saveoassignment.data

import com.dev.saveoassignment.jsonmodel.MovieModel
import com.dev.saveoassignment.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    /**
     * declaration of End point
     */

    @GET("shows")
    suspend fun getAllMovies(
        @Query("page") page: Int
    ): MovieModel
}