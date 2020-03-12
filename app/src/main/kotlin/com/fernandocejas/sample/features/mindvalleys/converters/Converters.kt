package com.fernandocejas.sample.features.mindvalleys.converters

import androidx.room.TypeConverter
import com.fernandocejas.sample.features.mindvalleys.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private fun convertToJson(any: Any?): String {
        return if (any == null) {
            ""
        } else {
            Gson().toJson(any)
        }
    }

    private fun <T> convertFromJson(data: String?, clazz: Class<T>): T? {
        return if (data.isNullOrEmpty()) {
            null
        } else {
            Gson().fromJson(data, clazz)
        }
    }

    @TypeConverter
    fun toCoverAsset(json: String): CovertAssetBO {
        val type = object : TypeToken<CovertAssetBO>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(torrent: CovertAssetBO) = Gson().toJson(torrent)

    @TypeConverter
    fun toChannelLink(json: String): ChannelLinkBO {
        val type = object : TypeToken<ChannelLinkBO>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(torrent: ChannelLinkBO) = Gson().toJson(torrent)

    //below are ChannelConverters
    @TypeConverter
    fun toSeriesList(json: String): List<SeriesBO> {
        val type = object : TypeToken<List<SeriesBO>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJsonSeries(torrent: List<SeriesBO>): String {
        val type = object: TypeToken<List<SeriesBO>>() {}.type
        return Gson().toJson(torrent, type)
    }

    @TypeConverter
    fun toMediaList(json: String): List<MediaBO> {
        val type = object : TypeToken<List<MediaBO>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJsonMedia(torrent: List<MediaBO>): String {
        val type = object: TypeToken<List<MediaBO>>() {}.type
        return Gson().toJson(torrent, type)
    }

    @TypeConverter
    fun toIconAsset(json: String): IconAssetBO? {
        return convertFromJson(json, IconAssetBO::class.java)
        /*val type = object : TypeToken<IconAssetBO>() {}.type
        return Gson().fromJson(json, type)*/
    }

    @TypeConverter
    fun toJson(iconAsset: IconAssetBO?) = convertToJson(iconAsset)//Gson().toJson(torrent)
}