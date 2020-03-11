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
import com.fernandocejas.sample.features.mindvalleys.models.EpisodeBO


class EpisodesAdapter internal constructor(var context: Context, private val episodes: List<EpisodeBO>) : RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_new_episode, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anEpisode = episodes[position]
        holder.tv_episode_heading.text = anEpisode.title
        holder.tv_episode_channel.text = anEpisode.channel.title
        anEpisode.coverAsset.url.let {
            Glide.with(context).load(anEpisode.coverAsset.url).transform(CenterCrop(), RoundedCorners(25)).into(holder.iv_episode_icon)
        }


        //Load Sub Adapter for this main Category


    }

    // total number of rows
    override fun getItemCount(): Int {
        return episodes.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_episode_heading: TextView = itemView.findViewById(R.id.tv_episode_heading)
        var tv_episode_channel: TextView = itemView.findViewById(R.id.tv_episode_channel)
        var iv_episode_icon: ImageView = itemView.findViewById(R.id.iv_episode_icon)
    }

}