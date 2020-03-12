package com.fernandocejas.sample.features.mindvalleys.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.fernandocejas.sample.features.mindvalleys.converters.Converters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class ChannelPayload(@SerializedName("channels") val payload: List<ChannelBO>)

@Entity(tableName = "ChannelEntity")
data class ChannelBO(@PrimaryKey(autoGenerate = true) val mID:Int,val title: String,
                     @TypeConverters(Converters::class) val series: List<SeriesBO>, val mediaCount: Int,
                     @TypeConverters(Converters::class) val latestMedia: List<MediaBO>,
                     val id: String?,
                     @TypeConverters(Converters::class) val iconAsset: IconAssetBO?,
                     @TypeConverters(Converters::class) val coverAsset: CovertAssetBO)

data class SeriesBO(val title: String, val id: String?, val coverAsset: CovertAssetBO)

data class MediaBO(val type: String, val title: String, val coverAsset: CovertAssetBO)

data class IconAssetBO(val thumbnailUrl: String, val url: String)


