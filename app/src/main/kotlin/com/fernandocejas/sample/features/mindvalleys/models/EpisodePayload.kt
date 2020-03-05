package com.fernandocejas.sample.features.mindvalleys.models

import com.google.gson.annotations.SerializedName

data class EpisodePayload(@SerializedName("media") val media:List<EpisodeBO>)

data class EpisodeBO(val type:String, val title:String, val coverAsset: CovertAssetBO, val channel: ChannelLinkBO)

data class CovertAssetBO(val url:String)

data class ChannelLinkBO(val title: ChannelLinkBO)