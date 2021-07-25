package com.dev.saveoassignment.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.saveoassignment.R
import com.dev.saveoassignment.model.ResponseModelItem

/**
 * Adapter class for recyclerview
 */
class VerticalAdapter(
    private var showLists: List<ResponseModelItem>,
    var onClickListener: ItemClickListener
) :
    RecyclerView.Adapter<VerticalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.vertical_layout, parent, false)
        return VerticalViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        val items = showLists[position]
        holder.setVerticalData(items)
    }

    override fun getItemCount(): Int {
        return showLists.size
    }

    fun updateVerticalData(showLists: List<ResponseModelItem>) {
        this.showLists = showLists
        notifyDataSetChanged()
    }


}