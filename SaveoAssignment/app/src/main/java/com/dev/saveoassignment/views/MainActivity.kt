package com.dev.saveoassignment.views

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.saveoassignment.R
import com.dev.saveoassignment.jsonmodel.MovieModelItem
import com.dev.saveoassignment.repository.MovieRepository
import com.dev.saveoassignment.viewmodel.MovieViewModel
import com.dev.saveoassignment.viewmodel.MovieViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var movieViewModel: MovieViewModel
    private val showList = mutableListOf<MovieModelItem>()
    private val showVerticalList = mutableListOf<MovieModelItem>()
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var verticalAdapter: VerticalAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    var num: Int = 1

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


        /**
         * Checking if internet connection is established or not
         */
        if (isNetworkConnected()) {
            observableHorizontalData()
            observableVertical()
            showPageNation()

        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Oops...")
            builder.setMessage("Please check your Internet connection")
            builder.setPositiveButton("Ok!", null)
            val alert: AlertDialog = builder.create()
            alert.show()
        }

    }


    /**
     * Observing data from view model
     */
    private fun observableVerticalData() {
        movieViewModel.getMovies(num).observe(this, Observer {
            showVerticalList.addAll(it)
            verticalAdapter.updateVerticalData(showVerticalList)
        })
    }

    /**
     * Observing data from view model
     */
    private fun observableVertical() {
        movieViewModel.getMovies(num).observe(this, Observer {
            progressBar.visibility = View.VISIBLE
            showVerticalList.clear()
            showVerticalList.addAll(it)
            progressBar.visibility = View.GONE
            nowShowing.visibility = View.VISIBLE
            verticalAdapter.updateVerticalData(showVerticalList)
        })
    }

    /**
     * Observing data from view model
     */
    private fun observableHorizontalData() {
        movieViewModel.getMovies(num).observe(this, Observer {
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

    /**
     * Setting the vertical recycleView component
     */
    private fun setVerticalRecyclerData() {
        verticalAdapter = VerticalAdapter(showVerticalList, this)
        gridLayoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        verticalRecycler.apply {
            layoutManager = gridLayoutManager
            adapter = verticalAdapter
        }
    }

    /**
     * Checking internet connection
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun isNetworkConnected(): Boolean {
        //1
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //2
        val activeNetwork = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        //3
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        //4
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    /**
     * Setting pagination to vertical recyclerview
     */
    private fun showPageNation() {
        var loading = true
        var pastVisiblesItems: Int
        var visibleItemCount: Int
        var totalItemCount: Int
        verticalRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = gridLayoutManager.getChildCount()
                    totalItemCount = gridLayoutManager.getItemCount()
                    pastVisiblesItems = gridLayoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            Log.v("VARUN", "Last Item Wow !")
                            num++
                            observableVerticalData()
                            loading = true
                        }
                    }
                }
            }
        })
    }

    /**
     * Sending data to ShowMovieDetails activity using intent
     */
    override fun onItemClick(movieModel: MovieModelItem, position: Int) {
        var intent = Intent(this, ShowMovieDetails::class.java)
        intent.putExtra("image", movieModel.image.medium)
        intent.putExtra("title", movieModel.name)
        intent.putExtra("time", movieModel.schedule.time)
        intent.putExtra("date", movieModel.premiered)
        intent.putExtra("language", movieModel.language)
        intent.putExtra("summery", movieModel.summary)
        startActivity(intent)

    }
}