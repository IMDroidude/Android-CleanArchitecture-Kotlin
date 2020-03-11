package com.fernandocejas.sample.features.mindvalleys.models

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.fernandocejas.sample.features.mindvalleys.WebResponse
import com.google.gson.annotations.SerializedName

///@Entity(tableName = "categoryPayload")
data class CategoryPayload(@SerializedName("categories") val categories: List<CategoryBO>)

@Entity(tableName = "CategoryEntity")
data class CategoryBO( @PrimaryKey(autoGenerate = true) val id:Int, val name:String)




/*
companion object {
        //fun empty() = CategoryPayload(ArrayList<CategoryBO>())
        fun emptyResponse() = WebResponse<CategoryPayload>(CategoryPayload(ArrayList<CategoryBO>()))

    }

    fun toCategoryList() :List<CategoryBO> {
        return this.categories
    }

    fun toEmptyList() :List<CategoryBO> {
        return ArrayList<CategoryBO>()
    }
 */