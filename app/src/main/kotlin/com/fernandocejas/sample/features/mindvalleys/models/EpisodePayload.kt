package com.fernandocejas.sample.features.mindvalleys.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class EpisodePayload(@SerializedName("media") val media:List<EpisodeBO>)

@Entity(tableName = "EpisodeEntity")
data class EpisodeBO(@PrimaryKey(autoGenerate = true) val id:Int,val type:String, val title:String, val coverAsset: CovertAssetBO, val channel: ChannelLinkBO)

@Entity(tableName = "CoverAssetEntity")
data class CovertAssetBO(val url:String)

@Entity(tableName = "ChannelLinkEntity")
data class ChannelLinkBO(val title: String)