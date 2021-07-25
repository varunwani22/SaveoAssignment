package com.dev.saveoassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.saveoassignment.model.ResponseModel
import com.dev.saveoassignment.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {


    fun getMovies(q: String): LiveData<ResponseModel> {
        return liveData(Dispatchers.IO) {
            val result = repository.getAllMovies(q)
            emit(result.data!!)
        }
    }
}