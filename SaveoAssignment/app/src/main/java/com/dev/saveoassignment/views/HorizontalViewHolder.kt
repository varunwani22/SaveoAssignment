package com.dev.saveoassignment.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev.saveoassignment.model.ResponseModelItem
import com.dev.saveoassignment.model.Show
import kotlinx.android.synthetic.main.horizontal_layout.view.*

class HorizontalViewHolder(itemView: View, var onClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(show: ResponseModelItem) {
        itemView.apply {
            Glide.with(ivHzImage).load(show.show.image.medium).into(ivHzImage)
//            hzCard.setOnClickListener {
//                onClickListener.onItemClick(responseModelItem, adapterPosition)
//            }
        }

    }
}