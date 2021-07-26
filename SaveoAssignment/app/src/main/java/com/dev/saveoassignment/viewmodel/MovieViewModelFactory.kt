package com.dev.saveoassignment.viewmodel

import com.dev.saveoassignment.repository.MovieRepository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MovieViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T
    }

}