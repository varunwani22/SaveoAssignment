package com.dev.saveoassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.saveoassignment.R
import com.dev.saveoassignment.model.ResponseModelItem
import com.dev.saveoassignment.model.Show
import com.dev.saveoassignment.repository.MovieRepository
import com.dev.saveoassignment.viewmodel.MovieViewModel
import com.dev.saveoassignment.viewmodel.MovieViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var movieViewModel: MovieViewModel
    private val showList = mutableListOf<ResponseModelItem>()
    private val showVerticalList = mutableListOf<ResponseModelItem>()
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var verticalAdapter: VerticalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHorizontalRecyclerData()
        setVerticalRecyclerData()


        val repository by lazy {
            MovieRepository()
        }

        val viewModelFactory = MovieViewModelFactory(repository)
        movieViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(MovieViewModel::class.java)

        observableHorizontalData()
        observableVerticalData()
    }


    private fun observableVerticalData() {
        movieViewModel.getMovies("god").observe(this, Observer {
            showVerticalList.clear()
            showVerticalList.addAll(it)
            verticalAdapter.updateVerticalData(showVerticalList)
        })
    }

    private fun observableHorizontalData() {
        movieViewModel.getMovies("god").observe(this, Observer {
            showList.clear()
            showList.addAll(it)
            horizontalAdapter.updateData(showList)
        })
    }

    /**
     * Setting the recycleView component
     */

    private fun setHorizontalRecyclerData() {
        horizontalAdapter = HorizontalAdapter(showList, this)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecycler.apply {
            layoutManager = linearLayoutManager
            adapter = horizontalAdapter
        }
    }

    private fun setVerticalRecyclerData() {
        verticalAdapter = VerticalAdapter(showVerticalList, this)
        val gridLayoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        verticalRecycler.apply {
            layoutManager = gridLayoutManager
            adapter = verticalAdapter
        }
    }
}