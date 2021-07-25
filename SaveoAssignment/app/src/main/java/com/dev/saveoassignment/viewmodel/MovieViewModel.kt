package com.dev.saveoassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.saveoassignment.jsonmodel.MovieModel
import com.dev.saveoassignment.model.ResponseModel
import com.dev.saveoassignment.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {


    fun getMovies(q: Int): LiveData<MovieModel> {
        return liveData(Dispatchers.IO) {
            val result = repository.getAllMovies(q)
            emit(result.data!!)
        }
    }
}