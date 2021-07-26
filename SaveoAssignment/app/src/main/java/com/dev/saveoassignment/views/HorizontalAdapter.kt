package com.dev.saveoassignment.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.saveoassignment.R
import com.dev.saveoassignment.jsonmodel.MovieModelItem
import com.dev.saveoassignment.model.ResponseModelItem
import com.dev.saveoassignment.model.Show

/**
 * Adapter class for recyclerview
 */
class HorizontalAdapter(
    private var showList: List<MovieModelItem>,
    var onClickListener: ItemClickListener
) :
    RecyclerView.Adapter<HorizontalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_layout, parent, false)
        return HorizontalViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val items = showList[position]
        holder.setData(items)
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    fun updateData(showList: List<MovieModelItem>) {
        this.showList = showList
        notifyDataSetChanged()
    }


}