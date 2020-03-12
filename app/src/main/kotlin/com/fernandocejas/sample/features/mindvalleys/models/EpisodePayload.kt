package com.fernandocejas.sample.features.mindvalleys.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.fernandocejas.sample.features.mindvalleys.converters.Converters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.Serializable

data class EpisodePayload(@SerializedName("media") val media:List<EpisodeBO>)

@Entity(tableName = "EpisodeEntity")
data class EpisodeBO(@PrimaryKey(autoGenerate = true) val id:Int, val type:String, val title:String,
                     @TypeConverters(Converters::class) val coverAsset: CovertAssetBO,
                     @TypeConverters(Converters::class) val channel: ChannelLinkBO)

///@Entity(tableName = "CoverAssetEntity")
data class CovertAssetBO(val url:String) : Serializable

///@Entity(tableName = "ChannelLinkEntity")
data class ChannelLinkBO(val title: String) : Serializable


/*
class CoverAssetConverter {
    @TypeConverter
    fun toCoverAsset(json: String): CovertAssetBO {
        val type = object : TypeToken<CovertAssetBO>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(torrent: CovertAssetBO) = Gson().toJson(torrent)
}

class ChannelLinkConverter {

    @TypeConverter
    fun toTorrent(json: String): ChannelLinkBO {
        val type = object : TypeToken<ChannelLinkBO>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(torrent: ChannelLinkBO) = Gson().toJson(torrent)
}*/
