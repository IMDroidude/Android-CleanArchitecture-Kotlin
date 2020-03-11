package com.fernandocejas.sample.features.mindvalleys.models

import com.google.gson.annotations.SerializedName

data class ChannelPayload(@SerializedName("channels") val payload: List<ChannelBO>)

data class ChannelBO(val title: String, val series: List<SeriesBO>, val mediaCount: Int, val latestMedia: List<MediaBO>,
                     val id: String, val iconAsset: IconAssetBO?, val coverAsset: CovertAssetBO)

data class SeriesBO(val title: String, val id: String?, val coverAsset: CovertAssetBO)

data class MediaBO(val type: String, val title: String, val coverAsset: CovertAssetBO)

data class IconAssetBO(val thumbnailUrl: String, val url: String)