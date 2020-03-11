package com.fernandocejas.sample.features.mindvalleys.rv_adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fernandocejas.sample.R
import com.fernandocejas.sample.core.custom_views.TextView
import com.fernandocejas.sample.features.mindvalleys.models.ChannelBO

class ChannelsAdapter internal constructor(var context: Context, private val channels: List<ChannelBO>) : RecyclerView.Adapter<ChannelsAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_main_channel, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aChannel = channels[position]
        holder.tv_channel_title.text = aChannel.title
        holder.tv_channel_episodes.text = "${aChannel.mediaCount} ${context.getString(R.string.episodes)}"

        aChannel.iconAsset?.let {
            if (TextUtils.isEmpty(it.thumbnailUrl) && TextUtils.isEmpty(it.url)) {
                holder.iv_episode_icon.visibility = View.GONE
            } else if (!TextUtils.isEmpty(it.thumbnailUrl)) {
                Glide.with(context).load(aChannel.iconAsset.thumbnailUrl).transform(CenterCrop(), RoundedCorners(25)).apply(RequestOptions().placeholder(R.drawable.ic_default_main_category_icon).error(R.drawable.ic_default_main_category_icon)).into(holder.iv_episode_icon)
            } else {
                Glide.with(context).load(aChannel.iconAsset.url).transform(CenterCrop(), RoundedCorners(25)).apply(RequestOptions().placeholder(R.drawable.ic_default_main_category_icon).error(R.drawable.ic_default_main_category_icon)).into(holder.iv_episode_icon)
            }
        }


        //Load Sub Adapter for this main Category
        if (aChannel.series.isNotEmpty()) {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            holder.rv_channel_detail.layoutManager = linearLayoutManager
            context.let { ctx ->
                val adapter = ChannelsSeriesAdapter(ctx, aChannel)
                holder.rv_channel_detail.adapter = adapter
            }
        } else {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            holder.rv_channel_detail.layoutManager = linearLayoutManager
            context.let { ctx ->
                val adapter = ChannelsLatestMediaAdapter(ctx, aChannel)
                holder.rv_channel_detail.adapter = adapter
                val animator = holder.rv_channel_detail.itemAnimator
                if (animator is SimpleItemAnimator) {
                    animator.supportsChangeAnimations = false
                }
            }
        }

    }

    // total number of rows
    override fun getItemCount(): Int {
        return channels.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_channel_title: TextView = itemView.findViewById(R.id.tv_channel_title)
        var tv_channel_episodes: TextView = itemView.findViewById(R.id.tv_channel_episodes)
        var iv_episode_icon: ImageView = itemView.findViewById(R.id.iv_main_category_icon)
        var rv_channel_detail: RecyclerView = itemView.findViewById(R.id.rv_channel_detail)

    }

}