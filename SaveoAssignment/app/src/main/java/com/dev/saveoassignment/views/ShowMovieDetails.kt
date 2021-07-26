package com.dev.saveoassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dev.saveoassignment.R
import kotlinx.android.synthetic.main.activity_show_movie_details.*

class ShowMovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_movie_details)
        settingDetails()

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun settingDetails() {
        val image = intent.getStringExtra("image")
        tvShowTitle.text = intent.getStringExtra("title")
        duration.text = intent.getStringExtra("time")
        date.text = intent.getStringExtra("date")
        setLanguage.text = intent.getStringExtra("language")
        tvDetails.text = intent.getStringExtra("summery")
        Glide.with(ivShowImage).load(image).into(ivShowImage)

    }
}