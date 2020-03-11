package com.fernandocejas.sample.features.mindvalleys.rv_adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fernandocejas.sample.R
import com.fernandocejas.sample.core.custom_views.TextView
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO


class CategoriesAdapter internal constructor(var context: Context, private val episodes: List<CategoryBO>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(mView)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aCategory = episodes[position]
        holder.tv_category_name.text = aCategory.name
    }

    // total number of rows
    override fun getItemCount(): Int {
        return episodes.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_category_name: TextView = itemView.findViewById(R.id.tv_category_name)
    }

}