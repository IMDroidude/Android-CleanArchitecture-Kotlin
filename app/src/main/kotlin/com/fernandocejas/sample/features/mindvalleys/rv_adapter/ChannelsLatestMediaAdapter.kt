package com.fernandocejas.sample.features.mindvalleys.rv_adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fernandocejas.sample.R
import com.fernandocejas.sample.core.custom_views.TextView
import com.fernandocejas.sample.features.mindvalleys.models.ChannelBO


class ChannelsLatestMediaAdapter internal constructor(var context: Context, private val channels: ChannelBO) : RecyclerView.Adapter<ChannelsLatestMediaAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_channel_media, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aMedia = channels.latestMedia[position]
        holder.tv_channel_heading.text = aMedia.title
        aMedia.coverAsset.url.let {
            Glide.with(context).load(aMedia.coverAsset.url).transform(CenterCrop(), RoundedCorners(25)).into(holder.iv_channel_icon)
        }


        //Load Sub Adapter for this main Category


    }

    // total number of rows
    override fun getItemCount(): Int {
        return channels.latestMedia.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_channel_heading: TextView = itemView.findViewById(R.id.tv_channel_heading)
        var iv_channel_icon: ImageView = itemView.findViewById(R.id.iv_channel_icon)
    }

}