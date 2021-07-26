package com.dev.saveoassignment.views

import com.dev.saveoassignment.jsonmodel.MovieModelItem


interface ItemClickListener {
    fun onItemClick(movieModel: MovieModelItem, position: Int)
}