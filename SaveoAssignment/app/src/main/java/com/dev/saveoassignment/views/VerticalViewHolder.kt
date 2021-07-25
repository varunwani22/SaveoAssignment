package com.dev.saveoassignment.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev.saveoassignment.R
import com.dev.saveoassignment.jsonmodel.MovieModelItem
import kotlinx.android.synthetic.main.vertical_layout.view.*

class VerticalViewHolder(itemView: View, var onClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setVerticalData(responseModelItem: MovieModelItem) {
        itemView.apply {
            Glide.with(ivVtImage).load(responseModelItem.image.medium)
                .error(R.drawable.ic_baseline_open_in_browser_24).into(ivVtImage)
            ivVtImage.setOnClickListener {
                onClickListener.onItemClick(responseModelItem, adapterPosition)
            }
        }

    }
}