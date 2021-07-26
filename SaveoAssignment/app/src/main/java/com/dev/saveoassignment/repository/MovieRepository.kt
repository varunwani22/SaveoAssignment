package com.dev.saveoassignment.repository

import com.dev.saveoassignment.data.ApiClient
import com.dev.saveoassignment.data.Network
import com.dev.saveoassignment.data.Resource
import com.dev.saveoassignment.data.ResponseHandler
import com.dev.saveoassignment.jsonmodel.MovieModel

class MovieRepository {
    /**
     * Response Handler is handling response from retrofit
     */
    private val responseHandler = ResponseHandler()

    /**
     * Calling API
     */
    val apiClient = Network.getInstance().create(ApiClient::class.java)

    suspend fun getAllMovies(q: Int): Resource<MovieModel> {
        val result = apiClient.getAllMovies(q)
        return responseHandler.handleSuccess(result)
    }
}