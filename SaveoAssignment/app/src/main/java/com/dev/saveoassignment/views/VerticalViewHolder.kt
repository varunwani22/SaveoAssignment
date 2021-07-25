package com.dev.saveoassignment.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev.saveoassignment.model.ResponseModelItem
import kotlinx.android.synthetic.main.vertical_layout.view.*

class VerticalViewHolder(itemView: View, var onClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setVerticalData(responseModelItem: ResponseModelItem) {
        itemView.apply {
            Glide.with(ivVtImage).load(responseModelItem.show.image.medium).into(ivVtImage)
//            hzCard.setOnClickListener {
//                onClickListener.onItemClick(responseModelItem, adapterPosition)
//            }
        }

    }
}