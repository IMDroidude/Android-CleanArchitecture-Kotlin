package com.fernandocejas.sample.features.mindvalleys.rv_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fernandocejas.sample.R
import com.fernandocejas.sample.core.custom_views.TextView
import com.fernandocejas.sample.features.mindvalleys.models.ChannelBO


class ChannelsSeriesAdapter internal constructor(var context: Context, private val channels: ChannelBO) : RecyclerView.Adapter<ChannelsSeriesAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(com.fernandocejas.sample.R.layout.item_series, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aSerial = channels.series[position]
        holder.tv_series_heading.text = aSerial.title
        aSerial.coverAsset.url.let {
            Glide.with(context).load(aSerial.coverAsset.url).transform(CenterCrop(), RoundedCorners(25)).into(holder.iv_series_icon)
        }
    }

    // total number of rows
    override fun getItemCount(): Int {
        return channels.series.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_series_heading: TextView = itemView.findViewById(R.id.tv_series_heading)
        var iv_series_icon: ImageView = itemView.findViewById(R.id.iv_series_icon)
    }

}